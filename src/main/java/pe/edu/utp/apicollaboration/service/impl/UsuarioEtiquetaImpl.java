package pe.edu.utp.apicollaboration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.apicollaboration.model.dao.UsuarioEtiquetaDao;
import pe.edu.utp.apicollaboration.model.entity.UsuarioEtiqueta;
import pe.edu.utp.apicollaboration.model.entity.UsuarioEtiquetaId;
import pe.edu.utp.apicollaboration.service.IUsuarioEtiqueta;

@Service
public class UsuarioEtiquetaImpl implements IUsuarioEtiqueta {

    @Autowired
    private UsuarioEtiquetaDao usuarioEtiquetaDao;

    @Override
    @Transactional
    public UsuarioEtiqueta save(UsuarioEtiqueta usuarioEtiqueta) {
        return usuarioEtiquetaDao.save(usuarioEtiqueta);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioEtiqueta findById(Long idUsuario, Long idEtiqueta) {
        return usuarioEtiquetaDao.findById(new UsuarioEtiquetaId(idUsuario, idEtiqueta)).orElse(null);
    }

    @Override
    @Transactional
    public void delete(UsuarioEtiqueta usuarioEtiqueta) {
        usuarioEtiquetaDao.delete(usuarioEtiqueta);
    }
}
