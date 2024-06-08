package pe.edu.utp.apicollaboration.model.dto.feed;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public record InvitacionesDto(
        Long idInvitacion,
        String texto,
        String nombreCurso,
        boolean estado_miembro
) {}
