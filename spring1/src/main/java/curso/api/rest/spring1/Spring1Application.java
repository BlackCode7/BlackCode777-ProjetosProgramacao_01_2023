package curso.api.rest.spring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan(basePackages = {"curso.api.rest.spring1.model"}) // Para criar as tabelas automáticas
@ComponentScan( basePackages = {"curso.*"})
@EnableJpaRepositories(basePackages = ("curso.api.rest.spring1.repository"))
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
public class Spring1Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring1Application.class, args);
	}

}
