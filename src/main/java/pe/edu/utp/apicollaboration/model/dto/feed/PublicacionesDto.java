package pe.edu.utp.apicollaboration.model.dto.feed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Builder
public record PublicacionesDto(
        String texto,
        Long nroInteracciones,
        String linkImagen
) {}
