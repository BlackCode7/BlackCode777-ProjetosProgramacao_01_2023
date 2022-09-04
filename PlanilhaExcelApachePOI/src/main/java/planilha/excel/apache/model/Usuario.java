package planilha.excel.apache.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nomeUsuario;
	private String email;
	private String endereco;
	private int salario;
	
	public Usuario() {}	
	
	public Usuario(Integer id, String nomeUsuario, String email, String endereco, int salario) {
		super();
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.endereco = endereco;
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nomeUsuario=" + nomeUsuario + ", email=" + email + ", endereco=" + endereco
				+ ", salario=" + salario + "]";
	}
	public double getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}

}
