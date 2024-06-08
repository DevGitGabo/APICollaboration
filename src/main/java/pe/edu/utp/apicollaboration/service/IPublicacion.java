package pe.edu.utp.apicollaboration.service;

import pe.edu.utp.apicollaboration.model.entity.Publicacion;

public interface IPublicacion {
    Publicacion save(Publicacion publicacion);
    Publicacion findById(Long id);
    void delete(Publicacion publicacion);
}
