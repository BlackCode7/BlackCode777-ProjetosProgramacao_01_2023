package curso.api.rest.spring1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity /* Vira uma tabela no banco */
@Table(name="role")
@SequenceGenerator(name="seq_role", sequenceName = "seq_role", allocationSize = 1, initialValue = 1) /* sequência de geração automatica no banco */
public class Role implements GrantedAuthority{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
	private Long id;
	private String nomeRole; /* Papeis de usuário, ROLE_SECRETARIO / ROLE_GERENTE / ROLE_ADMINISTRADOR */
	
	@Override
	public String getAuthority() { /* Retorna o nome do papel de aceso do usuário com autorização*/
		return this.nomeRole;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

}
