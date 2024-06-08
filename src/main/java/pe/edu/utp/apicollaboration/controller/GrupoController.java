package pe.edu.utp.apicollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.entity.Grupo;
import pe.edu.utp.apicollaboration.service.IGrupo;

@RestController
@RequestMapping("/api/v1")
public class GrupoController {

    @Autowired
    private IGrupo grupoService;

    @PostMapping("/grupo")
    public Grupo create(@RequestBody Grupo grupo) {
        return grupoService.save(grupo);
    }

    @PutMapping("/grupo")
    public Grupo update(@RequestBody Grupo grupo) {
        return grupoService.save(grupo);
    }

    @DeleteMapping("/grupo/{id}")
    public void delete(@PathVariable Long id) {
        Grupo grupo = grupoService.findById(id);
        grupoService.delete(grupo);
    }

    @GetMapping("/grupo/{id}")
    public Grupo showById(@PathVariable Long id) {
        return grupoService.findById(id);
    }
}
