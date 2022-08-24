package curso.api.rest.spring1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.spring1.model.Usuario;
import curso.api.rest.spring1.repository.UsuarioRepository;
import curso.api.rest.spring1.utils.ValidationPostApiUtils;

@RestController 
@RequestMapping(value = "/usuario")
public class IndexController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@DeleteMapping(value = "/{id}", produces = "application/text")
	public String deleteIDVenda(@PathVariable("id") Long id) {
		usuarioRepository.deleteById(id);
		return "OK Usuário deletado com SUCESSO !";
	}
	
	@PutMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
	}

	/* Passando varios parametros com @PathVariable
	@PostMapping(value = "/{iduser}/idvendas/{idvendas}", produces = "application/json")
	public ResponseEntity passando2ParametrosOuMais(@PathVariable Long iduser, @PathVariable Long idvendas) {
		//Usuario usuarioSalvo = usuarioRepository.save(usuario);
		return new ResponseEntity("id user: " + iduser + " id vendas: " + idvendas, HttpStatus.OK);
	} */	
	
	@PostMapping(value = "/", produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {		
		Usuario usuarioSalvo = usuarioRepository.save(ValidationPostApiUtils.validate(usuario));
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK) ;
	}	
	
	@GetMapping(value = "/{id}/codigovenda/{venda}", produces = "application/json")
	public ResponseEntity<Usuario> idVenda(@PathVariable(value = "id") Long id,
			@PathVariable(value = "venda") Long venda) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		/* retorno seria um relatorio */
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}

	
	@GetMapping(value = "/{id}/relatoriopdf", produces = "application/json")
	public ResponseEntity<Usuario> relatorio(@PathVariable(value = "id") Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		/* retorno seria um relatorio */
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}

	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> init(@PathVariable(value = "id") Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}

	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> usuario() {
		List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}

	/*
	 * Retornando json na tela com dados do usuário em forma de lista
	 * 
	 * @GetMapping(value="/", produces="application/json") public
	 * ResponseEntity<Usuario> init(){
	 * 
	 * Usuario usuario = new Usuario(); usuario.setId(10L);
	 * usuario.setLogin("Anderson.123"); usuario.setNome("Anderson");
	 * usuario.setSenha("admin");
	 * 
	 * Usuario usuario1 = new Usuario(); usuario1.setId(11L);
	 * usuario1.setLogin("Marcos.123"); usuario1.setNome("Marcos");
	 * usuario1.setSenha("admin1");
	 * 
	 * List<Usuario> usuarios = new ArrayList<Usuario>(); usuarios.add(usuario);
	 * usuarios.add(usuario1);
	 * 
	 * return new ResponseEntity(usuarios, HttpStatus.OK); }
	 */

	/*
	 * Retornando json na tela com dados do usuário
	 * 
	 * @GetMapping(value="/", produces="application/json") public
	 * ResponseEntity<Usuario> init(){
	 * 
	 * Usuario usuario = new Usuario(); usuario.setId(10L);
	 * usuario.setLogin("Anderson.123"); usuario.setNome("Anderson");
	 * usuario.setSenha("admin");
	 * 
	 * return ResponseEntity.ok(usuario); }
	 */

	/*
	 * Passando parametros
	 * 
	 * @GetMapping(value="/", produces="application/json") public ResponseEntity
	 * initParametro( @RequestParam(value="nome", defaultValue = "Família Martins")
	 * String nome ){ System.out.println("imprimindo no console " + nome); return
	 * new ResponseEntity("Passando paramatro, seu nome é : " + nome,
	 * HttpStatus.OK); }
	 */

	/*
	 * Serviço restfull
	 * 
	 * @GetMapping(value="/", produces="application/json") public ResponseEntity
	 * init(){ return new ResponseEntity("Olá mundo Spring boot!", HttpStatus.OK); }
	 */

}
