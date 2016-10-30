package dundermifflin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application {

    @Value("${target.securityKey}")
    private String targetSecurityKey;
    @Value("${database.host}")
    private String databaseHost;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public String targetSecurityKey() {
        return targetSecurityKey;
    }

    @Bean
    public String databaseHost() {
        return databaseHost;
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
