package planilha.excel.apache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import planilha.excel.apache.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
