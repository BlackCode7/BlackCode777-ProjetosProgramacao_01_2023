package curso.springboot_2.springboot_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import curso.springboot_2.springboot_2.model.Pessoa;
import curso.springboot_2.springboot_2.repository.PessoaRepository;

@Controller
public class PessoaController { // Aula 32.5
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@RequestMapping(method = RequestMethod.GET, value="/cadastropessoa")
	public String inicio() {
		return "cadastro/cadastropessoa";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/salvarpessoa")
	public String salvar( Pessoa pessoa ) {
		pessoaRepository.save(pessoa);
		return "cadastro/cadastropessoa";
	}
}
