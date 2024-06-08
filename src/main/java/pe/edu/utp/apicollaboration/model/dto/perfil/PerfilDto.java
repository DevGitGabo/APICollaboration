package pe.edu.utp.apicollaboration.model.dto.perfil;

import pe.edu.utp.apicollaboration.model.entity.Publicacion;

import java.util.List;

public record PerfilDto(
        Long id,
        String nombreCompleto, //usuario
        String codigoAlumno, //usuario
        Long numeroPublicaciones, //feed
        Long numeroSeguidores, //followrs
        Long numeroSeguidos, //followrs
        Long numeroMVP, //usuario
        List<String> insignias,
        List<Publicacion> publicacions, //feed
        String descripcion //usuario

) {

}
