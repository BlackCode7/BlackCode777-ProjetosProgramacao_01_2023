package curso.springboot_2.springboot_2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.springboot_2.springboot_2.model.Pessoa;
import curso.springboot_2.springboot_2.model.Telefone;
import curso.springboot_2.springboot_2.repository.PessoaRepository;
import curso.springboot_2.springboot_2.repository.TelefoneRepository;

@Controller
public class PessoaController { // Aula 32.5

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private TelefoneRepository telefoneRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/cadastropessoa")
	public ModelAndView inicio() {
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastropessoa");
		modelAndView.addObject("pessoaObj", new Pessoa());

		Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
		modelAndView.addObject("pessoas", pessoasIt);

		return modelAndView;
	}

	// Salvar dados
	@RequestMapping(method = RequestMethod.POST, value = "/salvarpessoa")
	public ModelAndView salvar( @Valid Pessoa pessoa, BindingResult bindingResult ) {
		
		if( bindingResult.hasErrors() ) { // Validando os dados
			ModelAndView andView = new ModelAndView("/cadastro/cadastropessoa");
			Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
			andView.addObject("pessoas", pessoasIt);
			andView.addObject("pessoaobj", pessoa);
			
			
			// Mostrando as validações na tela
			List<String> msg = new ArrayList<String>();
			
			// pegando a lista de erros e jogando na lista de mensagens
			for( ObjectError objectError : bindingResult.getAllErrors() ) {
				msg.add(objectError.getDefaultMessage()); // Esses erros vem da validação @NotNull @NotBlank @Min
			}
			andView.addObject("msg", msg);
			return andView;
		}
		
		pessoaRepository.save(pessoa);

		ModelAndView andView = new ModelAndView("/cadastro/cadastropessoa");
		Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
		andView.addObject("pessoas", pessoasIt);

		andView.addObject("pessoaobj", new Pessoa());

		return andView;
	}

	// Listagem de dados
	@RequestMapping(method = RequestMethod.GET, value = "/listapessoas")
	public ModelAndView pessoas() {
		ModelAndView andView = new ModelAndView("/cadastro/cadastropessoa");
		Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
		andView.addObject("pessoas", pessoasIt);

		andView.addObject("pessoaobj", new Pessoa());

		return andView;
	}

	// Editar
	@GetMapping("/editarpessoa/{idpessoa}")
	public ModelAndView editar(@PathVariable("idpessoa") Long idpessoa) {

		Optional<Pessoa> pessoa = pessoaRepository.findById(idpessoa);

		ModelAndView modelAndView = new ModelAndView("/cadastro/cadastropessoa");
		modelAndView.addObject("pessoaobj", pessoa.get());
		return modelAndView;
	}

	// excluirpessoa
	@GetMapping("/excluirpessoa/{idpessoa}")
	public ModelAndView excluir(@PathVariable("idpessoa") Long idpessoa) {
		// primeiro exclui
		pessoaRepository.deleteById(idpessoa);
		// depois volta pra mesma pagina e carrega os dados, menos o que foi excluido
		ModelAndView modelAndView = new ModelAndView("/cadastro/cadastropessoa");
		modelAndView.addObject("pessoas", pessoaRepository.findAll());
		modelAndView.addObject("pessoaobj", new Pessoa());
		return modelAndView;
	}

	@PostMapping("/pesquisarpessoa")
	public ModelAndView pesquisar(@RequestParam("nomepesquisa") String nomepesquisa) {

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastropessoa");
		modelAndView.addObject("pessoas", pessoaRepository.findPessoaByName(nomepesquisa));
		modelAndView.addObject("pessoaobj", new Pessoa());

		return modelAndView;
	}

	// Editar nome por telefone
	@GetMapping("/telefones/{idpessoa}")
	public ModelAndView telefones(@PathVariable("idpessoa") Long idpessoa) {

		Optional<Pessoa> pessoa = pessoaRepository.findById(idpessoa);

		ModelAndView modelAndView = new ModelAndView("/cadastro/telefones");
		modelAndView.addObject("pessoaobj", pessoa.get());
		modelAndView.addObject("telefones", telefoneRepository.getTelefonesField(idpessoa));
		return modelAndView;
	}

	// addFonePessoa
	@PostMapping("/addFonePessoa/{pessoaid}")
	public ModelAndView addFonePessoa( Telefone telefone,  @PathVariable( "pessoaid" ) Long pessoaid) {
		
		//Atribuindo o telefone a pessoa e salvando no banco
		Pessoa pessoa = pessoaRepository.findById(pessoaid).get();
		
		// Validando telefone / mostrando mensagem de erro
		if( telefone != null && telefone.getNumero().isEmpty() || telefone.getTipo().isEmpty()) {
			//retorna pra tela de cadastro
			ModelAndView modelAndView = new ModelAndView("cadastro/telefones"); 
			//retorna os objetos pessoa
			modelAndView.addObject("pessoaobj", pessoa);
			//retorna os objetos telefone
			modelAndView.addObject("telefones", telefoneRepository.getTelefonesField(pessoaid));
			//reorna a mensagem de erro
			List<String> msg = new ArrayList<String>();
			
			if( telefone.getNumero().isEmpty() ) {
				msg.add("Número deve ser informado!");
			}
			if( telefone.getTipo().isEmpty()) {
				msg.add("Tipo de deve ser informado!");
			}
		
			
			
			modelAndView.addObject("msg", msg);
			
			return modelAndView;
		}
		
		telefone.setPessoa(pessoa);
		telefoneRepository.save(telefone);//
		
		ModelAndView modelAndView = new ModelAndView("cadastro/telefones");
		modelAndView.addObject("pessoaobj", pessoa);
		modelAndView.addObject("telefones", telefoneRepository.getTelefonesField(pessoaid));
		return modelAndView;
	}
	
	// excluirtelefone
	@GetMapping("/excluirtelefone/{idtelefone}")
	public ModelAndView excluirtelefone(@PathVariable("idtelefone") Long idtelefone) {
		
		Pessoa pessoa = telefoneRepository.findById(idtelefone).get().getPessoa();
		
		// primeiro exclui
		telefoneRepository.deleteById(idtelefone);
		// depois volta pra mesma pagina e carrega os dados, menos o que foi excluido
		ModelAndView modelAndView = new ModelAndView("/cadastro/telefones");
		modelAndView.addObject("pessoaobj", pessoa);
		//Carrega os telefones
		modelAndView.addObject("telefones", telefoneRepository.getTelefonesField(pessoa.getId()));
		
		return modelAndView;
	}
	

}










