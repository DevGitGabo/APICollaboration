package pe.edu.utp.apicollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.entity.DetalleCurso;
import pe.edu.utp.apicollaboration.service.IDetalleCurso;

@RestController
@RequestMapping("/api/v1")
public class DetalleCursoController {

    @Autowired
    private IDetalleCurso detalleCursoService;

    @PostMapping("/detalleCurso")
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleCurso create(@RequestBody DetalleCurso detalleCurso) {
        return detalleCursoService.save(detalleCurso);
    }

    @PutMapping("/detalleCurso")
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleCurso update(@RequestBody DetalleCurso detalleCurso) {
        return detalleCursoService.save(detalleCurso);
    }

    @DeleteMapping("/detalleCurso/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        DetalleCurso detalleCurso = detalleCursoService.findById(id);
        detalleCursoService.delete(detalleCurso);
    }

    @GetMapping("/detalleCurso/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DetalleCurso showById(@PathVariable Long id) {
        return detalleCursoService.findById(id);
    }
}
