package pe.edu.utp.apicollaboration.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.utp.apicollaboration.model.entity.MiembroGrupo;

import java.util.List;

@Repository
public interface MiembroGrupoDao extends JpaRepository<MiembroGrupo, Long> {
    @Query(value = """
            SELECT mg FROM MiembroGrupo mg 
            WHERE mg.usuario.idUser = :idUsuario 
            AND mg.estadoMiembro = 'INVITADO'
            """)
    List<MiembroGrupo> findByUsuarioAndEstadoInvitado(@Param("idUsuario") Long idUsuario);
}

