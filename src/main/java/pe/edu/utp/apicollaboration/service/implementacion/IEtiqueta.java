package pe.edu.utp.apicollaboration.service.implementacion;

import pe.edu.utp.apicollaboration.model.entity.Etiqueta;

public interface IEtiqueta {
    Etiqueta save(Etiqueta etiqueta);
    Etiqueta findById(Long id);
    void delete(Etiqueta etiqueta);
}
