package pe.edu.utp.apicollaboration.model.dto.feed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
@AllArgsConstructor
public record InvitacionesDto(
        Long idInvitacion,
        String texto,
        String nombreCurso
) {}
