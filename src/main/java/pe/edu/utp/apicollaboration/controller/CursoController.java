package pe.edu.utp.apicollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.entity.Curso;
import pe.edu.utp.apicollaboration.service.ICurso;

@RestController
@RequestMapping("/api/v1")
public class CursoController {

    @Autowired
    private ICurso cursoService;

    @PostMapping("/curso")
    public Curso create(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @PutMapping("/curso")
    public Curso update(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @DeleteMapping("/curso/{id}")
    public void delete(@PathVariable Long id) {
        Curso curso = cursoService.findById(id);
        cursoService.delete(curso);
    }

    @GetMapping("/curso/{id}")
    public Curso showById(@PathVariable Long id) {
        return cursoService.findById(id);
    }
}
