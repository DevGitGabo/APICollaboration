package pe.edu.utp.collaborate.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.collaborate.model.entity.MiembroGrupo;

@Repository
public interface MiembroGrupoRepository extends CrudRepository<MiembroGrupo, Long> {
}
