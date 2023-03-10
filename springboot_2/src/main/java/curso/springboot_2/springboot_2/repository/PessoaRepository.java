package curso.springboot_2.springboot_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.springboot_2.springboot_2.model.Pessoa;

@Repository
@Transactional
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
	
	//Para fazer o campo de pesquisa por nome no html
	@Query( "select p from Pessoa p where p.nome like %?1% " )
	List<Pessoa> findPessoaByName(String nome);

} 
