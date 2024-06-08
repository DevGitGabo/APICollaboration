package pe.edu.utp.apicollaboration.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.apicollaboration.model.entity.Grupo;

import java.util.List;

@Repository
public interface GrupoDao extends CrudRepository<Grupo, Long> {

    @Query("SELECT g FROM Grupo g JOIN MiembroGrupo mg ON mg.grupo.idGrupo=g.idGrupo WHERE mg.usuario.idUser = :idUser")
    List<Grupo> findAllByIdUser(Long idUser);
}
