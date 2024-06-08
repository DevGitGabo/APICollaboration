package pe.edu.utp.apicollaboration.model.dao;

import org.springframework.data.repository.CrudRepository;
import pe.edu.utp.apicollaboration.model.entity.Publicacion;

public interface PublicacionDao extends CrudRepository<Publicacion, Long> {
}
