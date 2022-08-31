package curso.api.rest.spring1.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.api.rest.spring1.model.Usuario;

@Repository /* O repository é uma injeção de dependências */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	@Query("select u from Usuario u where u.login = ?1")/* significa parametro ?1 */
	Usuario findUserByLogin( String login );

}
