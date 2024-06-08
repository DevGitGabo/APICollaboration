package pe.edu.utp.apicollaboration.model.dto.feed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
@AllArgsConstructor
public record PublicarDto(
        Long idUsuario,
        String texto
) {}
