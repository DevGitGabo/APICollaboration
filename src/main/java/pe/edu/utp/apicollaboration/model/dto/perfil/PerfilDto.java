package pe.edu.utp.apicollaboration.model.dto.perfil;

import pe.edu.utp.apicollaboration.model.dto.feed.PublicacionesDto;
import pe.edu.utp.apicollaboration.model.entity.Insignia;
import pe.edu.utp.apicollaboration.model.entity.Usuario;

import pe.edu.utp.apicollaboration.model.entity.Publicacion;

import java.util.List;

public record PerfilDto(

        String nombreApellido,
        String codigoUniversitario,
        Long nroPublicaciones,
        Long nroSeguidores,
        Long nroSeguidos,
        Long nroMvp,
        List<String> nombreInsignias,
        List<PublicacionesDto> publicaciones,
        String descripcion,
        String linkImagen
        ) {
    public PerfilDto(Usuario usuario) {
        this(
                usuario.getNombre() + " " + usuario.getApellido(),
                usuario.getCodigoUniversitario(),
                (long) usuario.getPublicaciones().size(),
                (long) usuario.getSeguidores().size(),
                (long) usuario.getSeguidos().size(),
                (long) usuario.getNumMvp(),
                usuario.getInsignias().stream().map(Insignia::getNombreInsignia).toList(),
                usuario.getPublicaciones().stream().map(PublicacionesDto::new).toList(),
                usuario.getDescripcion(),
                usuario.getImagenUsuario()
        );
    }
}