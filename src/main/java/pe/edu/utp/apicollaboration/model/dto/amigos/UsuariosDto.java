package pe.edu.utp.apicollaboration.model.dto.amigos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import java.util.List;

@Builder
public record UsuariosDto(
        String nombre,
        List<String> nombreEtiquetas,
        String linkImagen,
        List<String> nombreInsignias,
        Long nroMvp,
        Boolean isSeguidor
){}
