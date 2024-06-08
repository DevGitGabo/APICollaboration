package pe.edu.utp.apicollaboration.service.implementacion;

import pe.edu.utp.apicollaboration.model.dto.feed.PublicarDto;
import pe.edu.utp.apicollaboration.model.entity.Publicacion;

public interface IPublicacion {
    Publicacion save(Publicacion publicacion);
    Publicacion saveForDto(PublicarDto publicacion);
    Publicacion findById(Long id);
    void delete(Publicacion publicacion);
}
