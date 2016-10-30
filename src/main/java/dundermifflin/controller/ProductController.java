package dundermifflin.controller;

import dundermifflin.bean.LocalProduct;
import dundermifflin.bean.Product;
import dundermifflin.bean.TargetProduct;
import dundermifflin.exception.DunderMifflinRuntimeException;
import dundermifflin.service.LocalProductService;
import dundermifflin.service.TargetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private @Autowired TargetProductService targetProductService;
    private @Autowired LocalProductService localProductService;

    @RequestMapping(value = "/{tcin}", method = RequestMethod.GET)
    public Product get(@PathVariable String tcin) {
        TargetProduct targetProduct = null;
        try {
            targetProduct = targetProductService.getTargetProduct(tcin);
        } catch(DunderMifflinRuntimeException e) { /*ignore*/ }

        LocalProduct localProduct = localProductService.get(tcin);

        Product product = null;
        if(targetProduct != null || localProduct != null)
            product = new Product(targetProduct, localProduct);
        return product;
    }
}
