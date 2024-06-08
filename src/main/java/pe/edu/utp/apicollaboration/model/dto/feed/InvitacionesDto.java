package pe.edu.utp.apicollaboration.model.dto.feed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import pe.edu.utp.apicollaboration.model.entity.Etiqueta;
import pe.edu.utp.apicollaboration.model.entity.Insignia;
import pe.edu.utp.apicollaboration.model.entity.MiembroGrupo;
import pe.edu.utp.apicollaboration.model.entity.Usuario;

import java.util.stream.Collectors;

@Builder
public record InvitacionesDto(
        Long idInvitacion,
        String texto,
        String nombreCurso,
        String estado_miembro
) {
    public InvitacionesDto (MiembroGrupo miembroGrupo) {
        this(
                miembroGrupo.getIdMiembro(),
                miembroGrupo.getGrupo().getNombreGrupo(),
                miembroGrupo.getGrupo().getCurso().getNombreCurso(),
                miembroGrupo.getEstadoMiembro()
        );
    }
}
