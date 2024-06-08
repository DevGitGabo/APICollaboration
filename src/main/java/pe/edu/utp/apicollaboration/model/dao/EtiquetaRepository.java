package pe.edu.utp.collaborate.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.collaborate.model.entity.Etiqueta;

@Repository
public interface EtiquetaRepository extends CrudRepository<Etiqueta, Long> {
}
