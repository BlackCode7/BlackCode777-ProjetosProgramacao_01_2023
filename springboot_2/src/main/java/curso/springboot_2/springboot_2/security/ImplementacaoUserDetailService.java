package curso.springboot_2.springboot_2.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import curso.springboot_2.springboot_2.model.Usuario;
import curso.springboot_2.springboot_2.repository.UsuarioRepository;

@Service
@Transactional
public class ImplementacaoUserDetailService implements UserDetailsService {
	
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findUserByLogin(username);
		
		// Validando se existe usuario
		if( usuario == null ) {
			throw new UsernameNotFoundException("Usuario não foi encontrado");
		}
		
		return new User(usuario.getLogin(), 
				usuario.getPassword(), 
				usuario.isEnabled(), 
				true, true, true ,
				usuario.getAuthorities());
	}

}
