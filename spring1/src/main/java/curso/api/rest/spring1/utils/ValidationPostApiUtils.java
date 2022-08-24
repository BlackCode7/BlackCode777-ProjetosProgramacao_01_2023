package curso.api.rest.spring1.utils;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import curso.api.rest.spring1.model.Usuario;

public class ValidationPostApiUtils {
	
	
	@SuppressWarnings("deprecation")
	public static Usuario validate( Usuario usuario ) throws CustomException {
		
		if( usuario == null || usuario.getLogin() == null ) {
			throw new CustomException( "Esses Campos são obrigatórios( login do usuario )!", HttpStatus.BAD_REQUEST );
		}		
		/* SWITCH case */
		switch(usuario.getLogin()) {
		case "1":			
		case "2":
			if( StringUtils.isEmpty(usuario.getNome()) || StringUtils.isEmpty(usuario.getLogin()) ) {
				throw new CustomException("Campo obrigatório(Nome)!", HttpStatus.BAD_REQUEST);
			}
			break;
		case "3":			
		case "4":
			if( StringUtils.isEmpty(usuario.getSenha()) || StringUtils.isEmpty(usuario.getLogin()) ) {
				throw new CustomException("Campo obrigatório(Senha)!", HttpStatus.BAD_REQUEST);
			}
			break;
		case "5":			
		case "6":
			if( StringUtils.isEmpty(usuario.getTelefones()) || StringUtils.isEmpty(usuario.getSenha()) || StringUtils.isEmpty(usuario.getNome()) ) {
				throw new CustomException("Campo obrigatório(Telefone)!", HttpStatus.BAD_REQUEST);
			}
			break;
		default:
			break;
		}		
		return usuario;
	}

}
