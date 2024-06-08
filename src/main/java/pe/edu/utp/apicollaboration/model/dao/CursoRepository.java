package pe.edu.utp.collaborate.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.collaborate.model.entity.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {
}
