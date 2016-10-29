package dundermifflin.repo;


import dundermifflin.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private @Autowired MongoTemplate mongoTemplate;

    public void save(Product product) {
        mongoTemplate.save(product);
    }

    public Product get(String id) {
        return mongoTemplate.findById(id, Product.class);
    }

    public void remove(Product product) {
        mongoTemplate.remove(product);
    }
}
