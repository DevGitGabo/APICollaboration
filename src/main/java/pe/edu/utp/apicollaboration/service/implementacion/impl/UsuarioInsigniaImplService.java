package pe.edu.utp.apicollaboration.service.implementacion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.apicollaboration.model.dao.UsuarioInsigniaDao;
import pe.edu.utp.apicollaboration.model.entity.UsuarioInsignia;
import pe.edu.utp.apicollaboration.model.entity.UsuarioInsigniaId;
import pe.edu.utp.apicollaboration.service.implementacion.IUsuarioInsignia;

@Service
public class UsuarioInsigniaImplService implements IUsuarioInsignia {

    @Autowired
    private UsuarioInsigniaDao usuarioInsigniaDao;

    @Override
    @Transactional
    public UsuarioInsignia save(UsuarioInsignia usuarioInsignia) {
        return usuarioInsigniaDao.save(usuarioInsignia);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioInsignia findById(Long idUsuario, Long idInsignia) {
        return usuarioInsigniaDao.findById(new UsuarioInsigniaId(idUsuario, idInsignia)).orElse(null);
    }

    @Override
    @Transactional
    public void delete(UsuarioInsignia usuarioInsignia) {
        usuarioInsigniaDao.delete(usuarioInsignia);
    }
}
