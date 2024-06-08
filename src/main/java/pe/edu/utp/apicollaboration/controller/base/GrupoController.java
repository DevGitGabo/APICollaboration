package pe.edu.utp.apicollaboration.controller.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.entity.Grupo;
import pe.edu.utp.apicollaboration.service.IGrupo;

@RestController
@RequestMapping("/api/v1")
public class GrupoController {

    @Autowired
    private IGrupo grupoService;

    /*@PostMapping("/grupo")
    @ResponseStatus(HttpStatus.CREATED)
    public Grupo create(@RequestBody Grupo grupo) {
        return grupoService.save(grupo);
    }*/

    /*@PutMapping("/grupo")
    @ResponseStatus(HttpStatus.CREATED)
    public Grupo update(@RequestBody Grupo grupo) {
        return grupoService.save(grupo);
    }*/

    @DeleteMapping("/grupo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Grupo grupo = grupoService.findById(id);
        grupoService.delete(grupo);
    }

    @GetMapping("/grupo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Grupo showById(@PathVariable Long id) {
        return grupoService.findById(id);
    }
}
