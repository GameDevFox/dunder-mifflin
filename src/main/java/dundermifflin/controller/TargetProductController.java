package dundermifflin.controller;

import dundermifflin.bean.TargetProduct;
import dundermifflin.service.TargetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/target-product")
public class TargetProductController {

    @Autowired
    private TargetProductService targetProductService;

    @RequestMapping(value = "/{tcin}", method = RequestMethod.GET)
    public TargetProduct getProduct(@PathVariable String tcin) {
        return targetProductService.getTargetProduct(tcin);
    }
}
