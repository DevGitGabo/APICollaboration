package pe.edu.utp.apicollaboration.service.implementacion;

import pe.edu.utp.apicollaboration.model.entity.Curso;

public interface ICurso {
    Curso save(Curso curso);
    Curso findById(Long id);
    void delete(Curso curso);
}
