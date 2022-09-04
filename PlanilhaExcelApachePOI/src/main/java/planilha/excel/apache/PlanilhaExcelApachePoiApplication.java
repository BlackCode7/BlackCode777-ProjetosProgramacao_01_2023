package planilha.excel.apache;

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

@SpringBootApplication
@EntityScan(basePackages = {"planilha.excel.apache.model"}) // Para criar as tabelas automáticas
@ComponentScan( basePackages = {"planilha.*"})
@EnableJpaRepositories(basePackages = ("planilha.excel.apache.repository"))
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
public class PlanilhaExcelApachePoiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanilhaExcelApachePoiApplication.class, args);
	}
	
	/* Configuração de cross origin */	
	public void addCorsMappings(CorsRegistry registry) {
		//WebMvcConfigurer.super.addCorsMappings(registry);
		// registry.addMapping("/usuario/**").allowedMethods("POST","GET","PUT","DELETE")
		registry.addMapping("/usuario/**") /* liberando somente o usuário */
		.allowedMethods("POST","GET","PUT","DELETE") /* liberando todos os métodos para o serviço de usuário */
		.allowedOrigins("*");
		//.allowedOrigins("https://github.com/BlackCode7"); //Libera todos os methodos para o cliente blackcode
	}

}
