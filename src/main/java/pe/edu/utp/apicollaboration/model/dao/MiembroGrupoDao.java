package pe.edu.utp.apicollaboration.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.utp.apicollaboration.model.dto.miembroGrupo.MiembroGrupoDto;
import pe.edu.utp.apicollaboration.model.entity.MiembroGrupo;

import java.util.List;

@Repository
public interface MiembroGrupoDao extends JpaRepository<MiembroGrupo, Long> {

    @Query("""
    SELECT NEW pe.edu.utp.apicollaboration.model.dto.miembroGrupo.MiembroGrupoDto(u.nombre, mg.rol) 
    FROM Usuario u 
    JOIN MiembroGrupo mg ON u.idUser = mg.usuario.idUser
    WHERE mg.grupo.idGrupo = :idGrupo
    """)
    List<MiembroGrupoDto> miembrosGrupo(@Param("idGrupo") Long idGrupo);


    @Query(value = """
        SELECT mg FROM MiembroGrupo mg 
        WHERE mg.usuario.idUser = :idUsuario 
        AND mg.estadoMiembro = 'INVITADO'
        """)
    List<MiembroGrupo> findByUsuarioAndEstadoInvitado(@Param("idUsuario") Long idUsuario);

}

