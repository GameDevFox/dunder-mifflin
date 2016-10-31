package dundermifflin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TargetRestUrlBuilder {

    private @Autowired @Qualifier("targetBaseUrl") String targetBaseUrl;
    private @Autowired @Qualifier("targetSecurityKey") String targetSecurityKey;

    public String buildUrl(String tcin) {
        return buildUrl(tcin, "descriptions,pricing,images");
    }

    public String buildUrl(String tcin, String fields) {
        String result = targetBaseUrl +
                "/products/v3/" + tcin +
                "?fields=" + fields +
                "&id_type=TCIN" +
                "&key="+targetSecurityKey;
        return result;
    }
}
