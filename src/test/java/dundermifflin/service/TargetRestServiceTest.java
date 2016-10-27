package dundermifflin.service;

import dundermifflin.bean.Product;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TargetRestServiceTest {

    @Value("classpath:target-response-13860429.json")
    private Resource responseFile;

    private @Autowired TargetRestUrlBuilder targetRestUrlBuilder;
    private @Autowired TargetRestService targetRestService;

    @Test
    public void getProduct() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        MockRestServiceServer server = MockRestServiceServer.bindTo(restTemplate).build();

        String url = targetRestUrlBuilder.buildUrl("13860429");
        String response = getResponse();
        server.expect(ExpectedCount.once(), requestTo(url))
            .andExpect(method(HttpMethod.GET))
            .andRespond(withSuccess(response, MediaType.APPLICATION_JSON));

        Product product = targetRestService.getProduct("13860429");

        assertThat(product.getId()).isEqualTo("13860429");
        assertThat(product.getName()).isEqualTo("SpongeBob SquarePants: SpongeBob's Frozen Face-off");
        assertThat(product.getPrice()).isEqualTo(7.5f);
        assertThat(product.getPageUrl()).isEqualTo("http://www.target.com/p/spongebob-squarepants-s-frozen-face-off/-/A-13860429");
        assertThat(product.getImageUrl()).isEqualTo("http://target.scene7.com/is/image/Target/13860429?wid=410&hei=410");
    }

    private String getResponse() throws IOException {
        InputStream inputStream = responseFile.getInputStream();
        String result = IOUtils.toString(inputStream);
        return result;
    }
}
