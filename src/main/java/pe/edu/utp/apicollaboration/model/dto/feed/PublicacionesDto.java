package pe.edu.utp.apicollaboration.model.dto.feed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import pe.edu.utp.apicollaboration.model.entity.MiembroGrupo;
import pe.edu.utp.apicollaboration.model.entity.Publicacion;

@Builder
public record PublicacionesDto(
        String texto,
        Long nroInteracciones,
        String linkImagen,
        String nombrePublicador
) {
    public PublicacionesDto (Publicacion publicacion) {
        this(
                publicacion.getTextoPublicacion(),
                publicacion.getInteracciones(),
                publicacion.getImagenPublicacion(),
                publicacion.getUsuario().getNombre() + " " + publicacion.getUsuario().getApellido()
        );
    }
}
