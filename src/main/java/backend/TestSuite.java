package backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by aslan.atasoy on 06/08/2017.
 */


@SpringBootApplication
@ComponentScan(value = "backend")
@EnableJpaRepositories(value = "backend.repository")
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = {RepositoryRestMvcAutoConfiguration.class})
public class TestSuite extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TestSuite.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TestSuite.class);
    }
}
