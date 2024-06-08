package pe.edu.utp.apicollaboration.service.implementacion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.apicollaboration.model.dao.PublicacionDao;
import pe.edu.utp.apicollaboration.model.dto.feed.PublicarDto;
import pe.edu.utp.apicollaboration.model.entity.Publicacion;
import pe.edu.utp.apicollaboration.model.entity.Usuario;
import pe.edu.utp.apicollaboration.service.implementacion.IPublicacion;

@Service
public class PublicacionImplService implements IPublicacion {

    @Autowired
    private PublicacionDao publicacionDao;
    @Autowired
    private UsuarioImplService usuarioService;

    @Override
    @Transactional
    public Publicacion save(Publicacion publicacion) {
        return publicacionDao.save(publicacion);
    }

    @Override
    @Transactional
    public Publicacion saveForDto(PublicarDto publicacion) {
        Usuario usuario = usuarioService.findById(publicacion.idUsuario());

        Publicacion publica = new Publicacion(publicacion, usuario);
        return publicacionDao.save(publica);
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
