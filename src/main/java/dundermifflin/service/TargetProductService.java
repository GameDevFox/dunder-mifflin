package dundermifflin.service;

import dundermifflin.bean.TargetProduct;
import dundermifflin.exception.DunderMifflinRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class TargetProductService {

    @Autowired
    private TargetRestUrlBuilder targetRestUrlBuilder;

    public TargetProduct getTargetProduct(String tcin) {
        Map item = getItem(tcin);

        TargetProduct targetProduct = buildProduct(item);
        targetProduct.setId(tcin);
        return targetProduct;
    }

    public Map getItem(String tcin) {
        String url = targetRestUrlBuilder.buildUrl(tcin);

        RestTemplate restTemplate = new RestTemplate();
        Map response = restTemplate.getForObject(url, Map.class);

        Map item = buildItem(response);

        Object errors = item.get("errors");
        if(errors != null) {
            List errorList = (List) errors;
            Map errorItem = (Map) errorList.get(0);
            String message = (String) errorItem.get("message");
            throw new DunderMifflinRuntimeException("Target API returned error: " + message);
        }

        return item;
    }

    private Map buildItem(Map map) {
        Map productCompositeResponse = (Map) map.get("product_composite_response");
        List items = (List) productCompositeResponse.get("items");

        Map item;
        if(items.size() > 0)
            item = (Map) items.get(0);
        else
            item = null;

        return item;
    }

    private TargetProduct buildProduct(Map item) {
        Map onlineDescription = (Map) item.get("online_description");
        String value = (String) onlineDescription.get("value");

        Map onlinePrice = (Map) item.get("online_price");
        String priceStr = (String) onlinePrice.get("current_price");
        float price = Float.valueOf(priceStr);

        String dataPageLink = (String) item.get("data_page_link");

        String imageUrl = null;
        Map images = (Map) item.get("image");
        List externalImageUrlList = (List) images.get("external_primary_image_url");
        if(externalImageUrlList.size() > 0)
            imageUrl = (String) externalImageUrlList.get(0);

        TargetProduct targetProduct = new TargetProduct();
        targetProduct.setName(value);
        targetProduct.setPrice(price);
        targetProduct.setPageUrl(dataPageLink);
        targetProduct.setImageUrl(imageUrl);

        return targetProduct;
    }
}

// NOTES: fields =
// extended_core,ids,descriptions,pos_messages,product_hierarchies,geographic_compliance,recall,dimensions,brand,
// relations,entertainment,restrictions,locations,pricing,in_store_locations,images,variations,reviews,user_attributes,
// color,size,pattern,license_asset,internal_images,vendor,nutrients,flexible_fulfillment,environmental,pharmacy,
// limited_segment,prepaid,store_product_type_hierarchy,store_merch_hierarchy,online_product_type_hierarchy,
// webclass_hierarchy,iac_categories,subscription,online_back_order,online_pre_order,purchase_enticement,fulfillment,
// manufacturer,extended_descriptions,all_fields_group,item_hierarchies,no_business_process_status,return_policy,
// no_online_inventory
