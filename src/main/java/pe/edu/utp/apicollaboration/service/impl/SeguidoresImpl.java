package pe.edu.utp.apicollaboration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.apicollaboration.model.dao.SeguidoresDao;
import pe.edu.utp.apicollaboration.model.entity.Seguidores;
import pe.edu.utp.apicollaboration.model.entity.SeguidoresId;
import pe.edu.utp.apicollaboration.service.ISeguidores;

@Service
public class SeguidoresImpl implements ISeguidores {

    @Autowired
    private SeguidoresDao seguidoresDao;

    @Override
    @Transactional
    public Seguidores save(Seguidores seguidores) {
        return seguidoresDao.save(seguidores);
    }

    @Override
    @Transactional(readOnly = true)
    public Seguidores findById(Long idSeguidor, Long idSeguido) {
        return seguidoresDao.findById(new SeguidoresId(idSeguidor, idSeguido)).orElse(null);
    }


    @Override
    @Transactional
    public void delete(Seguidores seguidores) {
        seguidoresDao.delete(seguidores);
    }
}
