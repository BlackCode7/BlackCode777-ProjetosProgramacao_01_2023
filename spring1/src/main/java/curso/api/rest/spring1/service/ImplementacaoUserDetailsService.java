package curso.api.rest.spring1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import curso.api.rest.spring1.model.Usuario;
import curso.api.rest.spring1.repository.UsuarioRepository;

@Service
public class ImplementacaoUserDetailsService implements UserDetailsService{	
	
	@Autowired
	private UsuarioRepository usuarioRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Consultar no banco o usuario se o usuário existe 		
		Usuario usuario = usuarioRepository.findUserByLogin(username);
		if( usuario == null ) {
			throw new UsernameNotFoundException("Usuário não encontrado no banco!");
		}
		
		/* usando os recursos do spring boot funções com User() padronizada do spring */
		return new User(usuario.getLogin(), usuario.getSenha(), usuario.getAuthorities());
	}

}
