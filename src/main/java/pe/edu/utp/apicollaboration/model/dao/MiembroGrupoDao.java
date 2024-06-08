package pe.edu.utp.apicollaboration.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.apicollaboration.model.entity.MiembroGrupo;

public interface MiembroGrupoDao extends CrudRepository<MiembroGrupo, Long> {
}
