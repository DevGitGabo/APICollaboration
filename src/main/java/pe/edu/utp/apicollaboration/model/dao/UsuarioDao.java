package pe.edu.utp.apicollaboration.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.utp.apicollaboration.model.entity.Usuario;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCodigoUniversitario(String codigoUniversitario);

    @Query("UPDATE Usuario u SET u.descripcion = :descripcion WHERE u.idUser = :idUser")
    Usuario updateDescriptionForUserById(Long idUser, String descripcion);

    @Query(value = """
            SELECT u.* FROM usuario u
            JOIN detalle_curso dc ON u.id_user = dc.id_usuario
            WHERE dc.id_curso IN (SELECT dc2.id_curso FROM detalle_curso dc2
            WHERE dc2.id_usuario = ?1 ) AND u.id_user != ?1
            """, nativeQuery = true)
    List<Usuario> findUsuariosInSameCourses(Long idUsuario);

    @Query(value = """
            SELECT u.* FROM usuario u
            WHERE (LOWER(u.nombre) LIKE LOWER(CONCAT('%', :texto, '%')) OR LOWER(u.apellido) LIKE LOWER(CONCAT('%', :texto, '%')))
            AND u.id_user != :idUsuario
            """, nativeQuery = true)
    List<Usuario> findUsuariosByNombreOrApellido(
            @Param("texto") String texto,
            @Param("idUsuario") Long idUsuario
    );

}
