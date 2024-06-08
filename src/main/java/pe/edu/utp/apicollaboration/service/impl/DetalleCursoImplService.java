package pe.edu.utp.apicollaboration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.apicollaboration.model.dao.DetalleCursoDao;
import pe.edu.utp.apicollaboration.model.entity.DetalleCurso;
import pe.edu.utp.apicollaboration.service.IDetalleCurso;

@Service
public class DetalleCursoImplService implements IDetalleCurso {

    @Autowired
    private DetalleCursoDao detalleCursoDao;

    @Override
    @Transactional
    public DetalleCurso save(DetalleCurso detalleCurso) {
        return detalleCursoDao.save(detalleCurso);
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleCurso findById(Long id) {
        return detalleCursoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(DetalleCurso detalleCurso) {
        detalleCursoDao.delete(detalleCurso);
    }
}
