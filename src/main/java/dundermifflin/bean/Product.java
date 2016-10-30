package dundermifflin.bean;

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

    public void setTargetProduct(TargetProduct targetProduct) {
        if(targetProduct == null)
            return;

        setId(targetProduct.getId());
        setName(targetProduct.getName());
        setBasePrice(targetProduct.getPrice());
        setPageUrl(targetProduct.getPageUrl());
        setImageUrl(targetProduct.getImageUrl());
    }

    public void setLocalProduct(LocalProduct localProduct) {
        if(localProduct == null)
            return;

        setId(localProduct.getId());
        setPrice(localProduct.getPrice());
        setRating(localProduct.getRating());
    }
}
