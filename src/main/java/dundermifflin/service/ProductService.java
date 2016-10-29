package dundermifflin.service;

import dundermifflin.bean.Product;
import dundermifflin.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private @Autowired ProductRepository productRepository;

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product get(String id) {
        return productRepository.get(id);
    }

    public void remove(Product product) {
        productRepository.remove(product);
    }

    public void remove(String id) {
        Product product = productRepository.get(id);
        productRepository.remove(product);
    }
}
