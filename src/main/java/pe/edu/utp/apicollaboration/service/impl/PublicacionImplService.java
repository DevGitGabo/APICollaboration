package pe.edu.utp.apicollaboration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.apicollaboration.model.dao.PublicacionDao;
import pe.edu.utp.apicollaboration.model.entity.Publicacion;
import pe.edu.utp.apicollaboration.service.IPublicacion;

@Service
public class PublicacionImplService implements IPublicacion {

    @Autowired
    private PublicacionDao publicacionDao;

    @Override
    @Transactional
    public Publicacion save(Publicacion publicacion) {
        return publicacionDao.save(publicacion);
    }

    @Override
    @Transactional(readOnly = true)
    public Publicacion findById(Long id) {
        return publicacionDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Publicacion publicacion) {
        publicacionDao.delete(publicacion);
    }
}
