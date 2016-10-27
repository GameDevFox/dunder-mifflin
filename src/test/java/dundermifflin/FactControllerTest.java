package dundermifflin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FactControllerTest {

    private @Autowired MockMvc mvc;

    @Test
    public void getFacts() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/facts/").accept(MediaType.APPLICATION_JSON);
        mvc.perform(builder)
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo(
                    "[`Bears eat beets`,`Bears`,`Beets`,`Battlestar Galactica`]".replace("`", "\"")
            )));
    }
}
