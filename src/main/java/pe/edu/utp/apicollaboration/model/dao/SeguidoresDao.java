package pe.edu.utp.apicollaboration.model.dao;

import org.springframework.data.repository.CrudRepository;
import pe.edu.utp.apicollaboration.model.entity.Seguidores;
import pe.edu.utp.apicollaboration.model.entity.SeguidoresId;

public interface SeguidoresDao extends CrudRepository<Seguidores, SeguidoresId> {
}
