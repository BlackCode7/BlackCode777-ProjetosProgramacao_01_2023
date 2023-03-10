package curso.api.rest.spring1.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import curso.api.rest.spring1.model.Usuario;

// Estabelece o gerenciador de token
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
	
	/* ***************** AULA 33.45 ****************** */

	protected JWTLoginFilter( String url, AuthenticationManager authenticationManager) {
		super( new AntPathRequestMatcher(url) );
		setAuthenticationManager(authenticationManager);
	}  
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {		
		Usuario user = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);		
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getSenha()));
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException {
		new JWTTokenAutenticacaoService().addAuthentication(response, authResult.getName());
	}
		
}