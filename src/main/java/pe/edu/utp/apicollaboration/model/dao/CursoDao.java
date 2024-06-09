package pe.edu.utp.apicollaboration.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.utp.apicollaboration.model.entity.Curso;

import java.util.Optional;

public interface CursoDao extends CrudRepository<Curso, Long> {
    @Query("SELECT c FROM Curso c WHERE c.idCurso = :id_curso")
    Optional<Curso> findCursoById_curso(@Param("id_curso") Long id_curso);

}
