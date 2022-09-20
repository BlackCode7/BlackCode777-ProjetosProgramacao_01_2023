package curso.springboot_2.springboot_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "curso.springboot_2.springboot_2.model" )
@ComponentScan(basePackages = {"curso.*"})
@EnableJpaRepositories(basePackages = { "curso.springboot_2.springboot_2.repository" })
@EnableTransactionManagement
public class Springboot2Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Springboot2Application.class, args);
		/*
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String result = encoder.encode("123b1"); // Carlos b166er // anderson 123 // Ricardo 123b1
		System.out.println(result); */
		
	}

}
