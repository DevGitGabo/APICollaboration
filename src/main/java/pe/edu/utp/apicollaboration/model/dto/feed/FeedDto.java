package pe.edu.utp.apicollaboration.model.dto.feed;

import lombok.Builder;

import java.util.List;

@Builder
public record FeedDto(
        List<InvitacionesDto> invitaciones,
        List<PublicacionesDto> publicaciones
) {
    public FeedDto(List<InvitacionesDto> invitaciones, List<PublicacionesDto> publicaciones) {
        this.invitaciones = invitaciones;
        this.publicaciones = publicaciones;
    }
}
