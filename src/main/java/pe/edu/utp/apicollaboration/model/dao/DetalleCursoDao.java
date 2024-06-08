package pe.edu.utp.apicollaboration.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.apicollaboration.model.entity.DetalleCurso;

@Repository
public interface DetalleCursoDao extends CrudRepository<DetalleCurso, Long> {
}
