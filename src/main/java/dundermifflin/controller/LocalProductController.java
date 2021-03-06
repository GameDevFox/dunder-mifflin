package dundermifflin.controller;

import dundermifflin.bean.LocalProduct;
import dundermifflin.service.LocalProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/local-product")
public class LocalProductController {

    private @Autowired
    LocalProductService localProductService;

    @RequestMapping(value = "/{tcin}", method = RequestMethod.GET)
    public LocalProduct get(@PathVariable String tcin) {
        return localProductService.get(tcin);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void post(@RequestBody LocalProduct localProduct) {
        localProductService.save(localProduct);
    }

    @RequestMapping(value = "/{tcin}", method = RequestMethod.PUT)
    public void put(@PathVariable String tcin, @RequestBody LocalProduct localProduct) {
        localProduct.setId(tcin);
        localProductService.save(localProduct);
    }

    @RequestMapping(value = "/{tcin}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String tcin) {
        localProductService.remove(tcin);
    }
}
