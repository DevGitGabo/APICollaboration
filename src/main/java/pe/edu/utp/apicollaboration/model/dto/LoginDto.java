package pe.edu.utp.apicollaboration.model.dto;

import lombok.Builder;
import lombok.ToString;


@Builder
public record LoginDto(
        String codigo_universitario,
        String contrasena)
{ }
