package pe.edu.utp.apicollaboration.service;

import pe.edu.utp.apicollaboration.model.entity.DetalleCurso;

public interface IDetalleCurso {
    DetalleCurso save(DetalleCurso detalleCurso);
    DetalleCurso findById(Long id);
    void delete(DetalleCurso detalleCurso);
}
