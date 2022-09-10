package br.com.blackcode.ProjetoAPI.ProjetoAPI.domain.repository;

import br.com.blackcode.ProjetoAPI.ProjetoAPI.domain.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

    Member findByUsername(String username);

    Optional<Member> findByToken(String token);
}
