package curso.api.rest.spring1.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

// Filtro em que todas as requisi;'oes erao capturadas para autenticar
public class JwtAutenticacaoFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// estasbelece  a auttentica;'ao para requisicao
		try {
			
			Authentication authentication = new JWTTokenAutenticacaoService().getAuthentication((HttpServletRequest) request);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			chain.doFilter(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
	}

}
