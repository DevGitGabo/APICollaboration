package pe.edu.utp.collaborate.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.collaborate.model.entity.Seguidores;
import pe.edu.utp.collaborate.model.entity.SeguidoresId;

@Repository
public interface SeguidoresRepository extends CrudRepository<Seguidores, SeguidoresId> {
}
