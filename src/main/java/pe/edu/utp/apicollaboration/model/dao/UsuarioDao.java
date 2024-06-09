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

    @Query("SELECT u FROM Usuario u JOIN u.detalleCursos dc WHERE dc.curso.idCurso " +
            "IN (SELECT dc2.curso.idCurso FROM DetalleCurso dc2 WHERE dc2.usuario.idUser = :idUsuario) " +
            "AND u.idUser != :idUsuario")
    List<Usuario> findUsuariosInSameCourses(@Param("idUsuario") Long idUsuario);


    @Query(value = """
            SELECT u.* FROM usuario u
            WHERE (LOWER(u.nombre) LIKE LOWER(CONCAT('%', :texto, '%')) 
            OR LOWER(u.apellido) LIKE LOWER(CONCAT('%', :texto, '%')))
            AND u.id_user != :idUsuario
            """, nativeQuery = true)
    List<Usuario> findUsuariosByNombreOrApellido(
            @Param("texto") String texto,
            @Param("idUsuario") Long idUsuario
    );

}
