package pe.edu.utp.apicollaboration.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.apicollaboration.model.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByCodigoUniversitario(String codigoUniversitario);

    @Query("UPDATE Usuario u SET u.descripcion = :descripcion WHERE u.idUser = :idUser")
    Usuario updateDescriptionForUserById(Long idUser, String descripcion);

}
