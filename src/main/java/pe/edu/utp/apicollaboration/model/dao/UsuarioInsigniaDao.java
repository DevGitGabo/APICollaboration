package pe.edu.utp.apicollaboration.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.apicollaboration.model.entity.UsuarioInsignia;
import pe.edu.utp.apicollaboration.model.entity.UsuarioInsigniaId;

@Repository
public interface UsuarioInsigniaDao extends CrudRepository<UsuarioInsignia, UsuarioInsigniaId> {
}
