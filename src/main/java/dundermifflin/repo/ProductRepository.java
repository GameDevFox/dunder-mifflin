package dundermifflin.repo;


import dundermifflin.bean.LocalProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private @Autowired MongoTemplate mongoTemplate;

    public void save(LocalProduct localProduct) {
        mongoTemplate.save(localProduct);
    }

    public LocalProduct get(String id) {
        return mongoTemplate.findById(id, LocalProduct.class);
    }

    public void remove(LocalProduct localProduct) {
        mongoTemplate.remove(localProduct);
    }
}
