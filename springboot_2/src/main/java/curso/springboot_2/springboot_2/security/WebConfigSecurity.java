package curso.springboot_2.springboot_2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


	/******************************  AULA 32.21 até 32.28   *******************************************/ 

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ImplementacaoUserDetailService implementacaoUserDetailService;
	

	@Override // Cria a autenticação do usuário com banco de dados ou em memória
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(implementacaoUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
		
		/* autenticação em mémoria para teste
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()) // A codificação da senha ainda não foi feita 
		.withUser("anderson")
		.password("$2a$10$8qZxwNSPvzz1eEv1n0KXqeIUZXO9GgKei9NE/.uWrCFLKYhCSyAKa")
		.roles("ADMIN");		*/ 
	}

	@Override // configura as solicitações de acesso por http
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
		.disable() // desabilita as configuraçãoes de memória
		.authorizeRequests() // permitir e restringir acessos
		
		.antMatchers(HttpMethod.GET, "/").permitAll() // qualquer usuario acessa a página inicial
		.antMatchers(HttpMethod.GET, "/cadastropessoa").hasAnyRole("ADMIN") // qualquer usuario acessa a página inicial
		.anyRequest().authenticated()
		.and().formLogin().permitAll() // permite qualquer usuario
		.and().logout() // Mapeia URL de logout e invalida usuario autenticado
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));		
	}
	
		
	@Override // Serve para ignorar URLs especificas pastas e configurações de css que qualquer usuario possa acessar
	public void configure(WebSecurity web) throws Exception {
		
		web.ignoring().antMatchers("/materialize/**");
		
		
	}
	
	
	
}













