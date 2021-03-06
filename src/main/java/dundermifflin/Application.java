package dundermifflin;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application {

    @Value("${target.baseUrl}")
    private String targetBaseUrl;
    @Value("${target.securityKey}")
    private String targetSecurityKey;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    @Qualifier("targetBaseUrl")
    public String getTargetBaseUrl() {
        return targetBaseUrl;
    }

    @Bean
    @Qualifier("targetSecurityKey")
    public String targetSecurityKey() {
        return targetSecurityKey;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("PUT","GET","POST","DELETE","OPTIONS");
            }
        };
    }
}
