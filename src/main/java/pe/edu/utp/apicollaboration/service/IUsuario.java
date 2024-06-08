package pe.edu.utp.apicollaboration.service;

import pe.edu.utp.apicollaboration.model.entity.Usuario;

public interface IUsuario {
    Usuario save (Usuario usuario);
    Usuario findById (Long id);
    void delete (Usuario usuario);
}
