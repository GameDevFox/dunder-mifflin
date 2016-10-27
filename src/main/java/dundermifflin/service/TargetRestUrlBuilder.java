package dundermifflin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TargetRestUrlBuilder {

    @Autowired
    private String targetSecurityKey;

    public String buildUrl(String tcin) {
        return buildUrl(tcin, "descriptions,pricing,images");
    }

    public String buildUrl(String tcin, String fields) {
        String result = "https://api.target.com/products/v3/" + tcin +
                "?fields=" + fields +
                "&id_type=TCIN" +
                "&key="+targetSecurityKey;
        return result;
    }
}
