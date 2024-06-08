package pe.edu.utp.apicollaboration.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
public record LoginDto(String usuario, String password) {
}
