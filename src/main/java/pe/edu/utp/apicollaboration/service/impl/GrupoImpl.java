package pe.edu.utp.apicollaboration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.apicollaboration.model.dao.GrupoDao;
import pe.edu.utp.apicollaboration.model.entity.Grupo;
import pe.edu.utp.apicollaboration.service.IGrupo;

@Service
public class GrupoImpl implements IGrupo {

    @Autowired
    private GrupoDao grupoDao;

    @Override
    @Transactional
    public Grupo save(Grupo grupo) {
        return grupoDao.save(grupo);
    }

    @Override
    @Transactional(readOnly = true)
    public Grupo findById(Long id) {
        return grupoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Grupo grupo) {
        grupoDao.delete(grupo);
    }
}
