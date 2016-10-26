package dundermifflin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facts")
public class FactController {

    private static String[] facts = {
        "Bears eat beets",
        "Bears",
        "Beets",
        "Battlestar Galactica"
    };

    @RequestMapping("/")
    public String[] getFacts() {
        return facts;
    }
}
