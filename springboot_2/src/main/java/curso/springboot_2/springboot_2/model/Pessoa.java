package curso.springboot_2.springboot_2.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@org.hibernate.validator.constraints.NotBlank(message="Não é permitido campo nome nulo!")
	@org.hibernate.validator.constraints.NotBlank(message="Não é permitido campo nome em branco!")
	private String nome;
	
	@org.hibernate.validator.constraints.NotBlank(message="Não é permitido campo sobrenome nulo!")
	@org.hibernate.validator.constraints.NotBlank(message="Não é permitido campo sobrenome branco!")
	private String sobrenome;
	
	@Min(value=18, message="Idade inválida !")
	private Long idade;
	
	@OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Telefone> telefones;
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	// Construtor
	public Pessoa() {
		super();
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
