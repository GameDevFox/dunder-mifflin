package dundermifflin.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Product extends TargetProduct {

    private Float basePrice;
    private Float rating;

    public Product() {}

    public Product(TargetProduct targetProduct, LocalProduct localProduct) {
        setLocalProduct(localProduct);
        setTargetProduct(targetProduct);
    }

    public Float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Float basePrice) {
        this.basePrice = basePrice;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @JsonIgnore
    public TargetProduct getTargetProduct() {
        TargetProduct targetProduct = new TargetProduct();
        targetProduct.setId(getId());
        targetProduct.setName(getName());
        targetProduct.setPrice(getPrice());
        targetProduct.setPageUrl(getPageUrl());
        targetProduct.setImageUrl(getImageUrl());

        return targetProduct;
    }

    public void setTargetProduct(TargetProduct targetProduct) {
        if(targetProduct == null)
            return;

        setId(targetProduct.getId());
        setName(targetProduct.getName());
        setBasePrice(targetProduct.getPrice());
        setPageUrl(targetProduct.getPageUrl());
        setImageUrl(targetProduct.getImageUrl());
    }

    @JsonIgnore
    public LocalProduct getLocalProduct() {
        LocalProduct localProduct = new LocalProduct();
        localProduct.setId(getId());
        localProduct.setPrice(getPrice());
        localProduct.setRating(getRating());

        return localProduct;
    }

    public void setLocalProduct(LocalProduct localProduct) {
        if(localProduct == null)
            return;

        setId(localProduct.getId());
        setPrice(localProduct.getPrice());
        setRating(localProduct.getRating());
    }
}
