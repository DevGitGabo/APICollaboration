package pe.edu.utp.apicollaboration.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.utp.apicollaboration.model.entity.Publicacion;

import java.util.List;

@Repository
public interface PublicacionDao extends JpaRepository<Publicacion, Long> {
    @Query("""
    SELECT p FROM Publicacion p WHERE p.usuario.idUser = :idUsuario OR 
    p.usuario.idUser IN (SELECT s.seguido.idUser FROM Seguidores s WHERE s.seguidor.idUser = :idUsuario)
    """)
    List<Publicacion> findPublicacionesByIdUsuarioAndSeguidores(@Param("idUsuario") Long idUsuario);

}
