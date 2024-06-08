package pe.edu.utp.collaborate.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.collaborate.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
