package pe.edu.utp.collaborate.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.collaborate.model.entity.UsuarioInsignia;
import pe.edu.utp.collaborate.model.entity.UsuarioInsigniaId;

@Repository
public interface UsuarioInsigniaRepository extends CrudRepository<UsuarioInsignia, UsuarioInsigniaId> {
}
