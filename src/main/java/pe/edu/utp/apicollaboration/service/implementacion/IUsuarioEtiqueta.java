package pe.edu.utp.apicollaboration.service.implementacion;

import pe.edu.utp.apicollaboration.model.entity.UsuarioEtiqueta;
import pe.edu.utp.apicollaboration.model.entity.UsuarioEtiquetaId;

public interface IUsuarioEtiqueta {
    UsuarioEtiqueta save(UsuarioEtiqueta usuarioEtiqueta);
    UsuarioEtiqueta findById(Long idUsuario, Long idEtiqueta);
    void delete(UsuarioEtiqueta usuarioEtiqueta);
}
