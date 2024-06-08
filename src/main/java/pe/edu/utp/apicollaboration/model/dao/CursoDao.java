package pe.edu.utp.apicollaboration.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.apicollaboration.model.entity.Curso;

@Repository
public interface CursoDao extends CrudRepository<Curso, Long> {
}
