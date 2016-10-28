package dundermifflin.service;

import dundermifflin.bean.Product;
import dundermifflin.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private @Autowired ProductRepository productRepository;

    public Product getProduct(String id) {
        Product product = productRepository.findOne(id);
        return product;
    }
}
