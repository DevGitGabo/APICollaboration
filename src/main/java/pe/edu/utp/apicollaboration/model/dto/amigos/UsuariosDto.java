package pe.edu.utp.apicollaboration.model.dto.amigos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import pe.edu.utp.apicollaboration.model.entity.Etiqueta;
import pe.edu.utp.apicollaboration.model.entity.Insignia;
import pe.edu.utp.apicollaboration.model.entity.Usuario;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record UsuariosDto(
        String nombre,
        List<String> nombreEtiquetas,
        String linkImagen,
        List<String> nombreInsignias,
        Long nroMvp,
        Boolean isSeguidor
){
    public UsuariosDto (Usuario usuario, boolean isSeguidor) {
        this(
                usuario.getNombre() +" "+ usuario.getApellido(),
                usuario.getEtiquetas().stream()
                        .map(Etiqueta::getNombreEtiqueta)
                        .collect(Collectors.toList()),
                usuario.getImagenUsuario(),
                usuario.getInsignias().stream()
                        .map(Insignia::getNombreInsignia)
                        .toList(),
                usuario.getNumMvp(),
                isSeguidor
        );
    }
}
