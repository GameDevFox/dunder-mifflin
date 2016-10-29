package dundermifflin.service;

import dundermifflin.bean.LocalProduct;
import dundermifflin.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalProductService {

    private @Autowired ProductRepository productRepository;

    public void save(LocalProduct localProduct) {
        productRepository.save(localProduct);
    }

    public LocalProduct get(String id) {
        return productRepository.get(id);
    }

    public void remove(LocalProduct localProduct) {
        productRepository.remove(localProduct);
    }

    public void remove(String id) {
        LocalProduct localProduct = productRepository.get(id);
        productRepository.remove(localProduct);
    }
}
