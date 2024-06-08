package pe.edu.utp.apicollaboration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.apicollaboration.model.dao.EtiquetaDao;
import pe.edu.utp.apicollaboration.model.entity.Etiqueta;
import pe.edu.utp.apicollaboration.service.IEtiqueta;

@Service
public class EtiquetaImplService implements IEtiqueta {

    @Autowired
    private EtiquetaDao etiquetaDao;

    @Override
    @Transactional
    public Etiqueta save(Etiqueta etiqueta) {
        return etiquetaDao.save(etiqueta);
    }

    @Override
    @Transactional(readOnly = true)
    public Etiqueta findById(Long id) {
        return etiquetaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Etiqueta etiqueta) {
        etiquetaDao.delete(etiqueta);
    }
}
