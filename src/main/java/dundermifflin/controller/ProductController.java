package dundermifflin.controller;

import dundermifflin.bean.Product;
import dundermifflin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private @Autowired ProductService productService;

    @RequestMapping(value = "/{tcin}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String tcin) {
        Product product = productService.getProduct(tcin);
        return product;
    }
}
