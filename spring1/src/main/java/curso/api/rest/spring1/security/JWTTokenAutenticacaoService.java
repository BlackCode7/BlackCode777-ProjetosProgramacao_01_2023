package curso.api.rest.spring1.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import curso.api.rest.spring1.ApplicationContextLoad;
import curso.api.rest.spring1.model.Usuario;
import curso.api.rest.spring1.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@Component
public class JWTTokenAutenticacaoService {
	
	/* ***************** AULA 33.44 ****************** */

	//https://www.google.com/search?q=converter+milliseconds+to+hours&oq=converte+milisecon&aqs=chrome.6.69i57j0i13l3j0i13i30l6.22577j0j7&sourceid=chrome&ie=UTF-8
	//tempo de validade do token
	private static final long EXPIRATION_TIME = 17280000;
	//Uma senha única para compor a autenticação exemplo >>>  *T(&¨%&$%T(*&¨$*%#!@$!#T(-
	private static final String SECRET = "*SenhaExtremamenteSecreta";
	//prefixo padrão de token
	private static final String TOKEN_PREFIX = "Bearer";
	//serve para identicar
	private static final String HEADER_STRING = "Authorization";
	
	//Metodo para gerar token de authenticação e adicionando o cabeça resposta para navegador
	public void addAuthentication( HttpServletResponse response, String username )  throws IOException {
		// Montagem do token 
		String JWT = Jwts.builder()//chama o gerador de token
								.setSubject(username)//chama o usuario que esta fazend o login
								.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))//tempo de expiração
								.signWith(SignatureAlgorithm.HS512, SECRET).compact();//chamadno o algoritmo que faz geração de senha					
		// Junta o token com o prefixo - Bearer 098-08)*_&-9(*jkbOjgug)860¨0 vai ficar assim
		String token = TOKEN_PREFIX + " " + JWT; 
		
		// Adicionando um objeto de resposta no cabeçalho da requisição
		response.addHeader(HEADER_STRING, token);		
		
		//Escrevendo no corpo body o token como resposta no http
		response.getWriter().write("{\"Authorization\": \""+token+"\"}");	
	}
	
	//Retorna o usuario validado com o token ou se não for valido retorno null
	public Authentication getAuthentication( HttpServletRequest request ) throws Exception {
		// Pega token enviado no cabeçalho http
		String token = request.getHeader(HEADER_STRING);
		if( token != null ) {
			//Faz validacao do token do usuario na requisição
			String user = Jwts.parser().setSigningKey(SECRET)//Ate aqui o taken vem assim &%(&%$&UGKJHV*&¨T(B
								.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
								.getBody().getSubject();//aqui descompacta o token			
			if( user != null ) {
				//Faz validação do usuario se existe ou nao o susuario
				Usuario usuario = ApplicationContextLoad.getApplicationontext()
											.getBean(UsuarioRepository.class).findUserByLogin(user);
				//retornar o usuario logado
				if( usuario != null ) {
					//Faz validação das credenciais do usuario
					return new UsernamePasswordAuthenticationToken(
							usuario.getLogin(), usuario.getSenha(), usuario.getAuthorities());
				}
			}
		}
		return null; //Não autorizado		
	}
	
	
}










