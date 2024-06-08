package pe.edu.utp.apicollaboration.service;

import pe.edu.utp.apicollaboration.model.entity.UsuarioInsignia;

public interface IUsuarioInsignia {
    UsuarioInsignia save(UsuarioInsignia usuarioInsignia);
    UsuarioInsignia findById(Long idUsuario, Long idInsignia);
    void delete(UsuarioInsignia usuarioInsignia);
}
