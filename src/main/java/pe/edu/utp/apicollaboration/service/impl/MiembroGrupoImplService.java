package pe.edu.utp.apicollaboration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.apicollaboration.model.dao.MiembroGrupoDao;
import pe.edu.utp.apicollaboration.model.entity.MiembroGrupo;
import pe.edu.utp.apicollaboration.service.IMiembroGrupo;

@Service
public class MiembroGrupoImplService implements IMiembroGrupo {

    @Autowired
    private MiembroGrupoDao miembroGrupoDao;

    @Override
    @Transactional
    public MiembroGrupo save(MiembroGrupo miembroGrupo) {
        return miembroGrupoDao.save(miembroGrupo);
    }

    @Override
    @Transactional(readOnly = true)
    public MiembroGrupo findById(Long id) {
        return miembroGrupoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(MiembroGrupo miembroGrupo) {
        miembroGrupoDao.delete(miembroGrupo);
    }
}
