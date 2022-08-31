package curso.api.rest.spring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan(basePackages = {"curso.api.rest.spring1.model"}) // Para criar as tabelas automáticas
@ComponentScan( basePackages = {"curso.*"})
@EnableJpaRepositories(basePackages = ("curso.api.rest.spring1.repository"))
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
public class Spring1Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Spring1Application.class, args);
	}
	
	/* Configuração de cross origin */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//WebMvcConfigurer.super.addCorsMappings(registry);
		// registry.addMapping("/usuario/**").allowedMethods("POST","GET","PUT","DELETE")
		registry.addMapping("/usuario/**") /* liberando somente o usuário */
		.allowedMethods("POST","GET","PUT","DELETE") /* liberando todos os métodos para o serviço de usuário */
		.allowedOrigins("*");
		//.allowedOrigins("https://github.com/BlackCode7"); //Libera todos os methodos para o cliente blackcode
	}

}
