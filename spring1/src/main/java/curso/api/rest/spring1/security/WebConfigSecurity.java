package curso.api.rest.spring1.security;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import curso.api.rest.spring1.service.ImplementacaoUserDetailsService;


// mapeia URL, endereço, autoriza ou bloqueia
@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter{
	
	// Configuração de solicitação http
	protected void configure( HttpSecurity http ) throws Exception{
		//Ativando a proteção contra usuarios que não estão vbalidados por token
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		//Ativando a restricao de url
		.disable().authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/index").permitAll()
		//URL de logout
		.anyRequest().authenticated().and().logout().logoutSuccessUrl("/logout")
		//Mapeia URL de logout e invalida o usuario
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		/*Filtra requisição de login para autenticação*/
		.and().addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), 
											UsernamePasswordAuthenticationFilter.class)
		
		/*Filtra as demais requisições para verificar a presença do  TOKEN JWT no HEADER HTTP */
		 .addFilterBefore(new JwtAutenticacaoFilter(), 
											UsernamePasswordAuthenticationFilter.class);
	}	

	@Autowired
	private ImplementacaoUserDetailsService implementacaoUserDetailsService;
	
	protected void configure( AuthenticationManagerBuilder auth) throws Exception{
		//Service usado para consultar o usuario no banco
		auth.userDetailsService( implementacaoUserDetailsService )
		// Tipo de encriptação de senha 
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
}
