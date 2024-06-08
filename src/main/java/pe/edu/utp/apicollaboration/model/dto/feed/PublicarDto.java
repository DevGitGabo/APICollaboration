package pe.edu.utp.apicollaboration.model.dto.feed;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public record PublicarDto(
        Long idUsuario,
        String texto
) {}
