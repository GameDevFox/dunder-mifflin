package dundermifflin.controller;

import dundermifflin.bean.Product;
import dundermifflin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private @Autowired ProductService productService;

    @RequestMapping(value = "/{tcin}", method = RequestMethod.GET)
    public Product get(@PathVariable String tcin) {
        return productService.get(tcin);
    }

    @RequestMapping(value = "/", method = { RequestMethod.POST, RequestMethod.PUT })
    public void put(@RequestBody Product product) {
        productService.save(product);
    }

    @RequestMapping(value = "/{tcin}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String tcin) {
        productService.remove(tcin);
    }
}
