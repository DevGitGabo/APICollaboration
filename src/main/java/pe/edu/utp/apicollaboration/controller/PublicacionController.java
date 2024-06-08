package pe.edu.utp.apicollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.entity.Publicacion;
import pe.edu.utp.apicollaboration.service.IPublicacion;

@RestController
@RequestMapping("/api/v1")
public class PublicacionController {

    @Autowired
    private IPublicacion publicacionService;

    @PostMapping("/publicacion")
    @ResponseStatus(HttpStatus.CREATED)
    public Publicacion create(@RequestBody Publicacion publicacion) {
        return publicacionService.save(publicacion);
    }

    @PutMapping("/publicacion")
    @ResponseStatus(HttpStatus.CREATED)
    public Publicacion update(@RequestBody Publicacion publicacion) {
        return publicacionService.save(publicacion);
    }

    @DeleteMapping("/publicacion/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Publicacion publicacion = publicacionService.findById(id);
        publicacionService.delete(publicacion);
    }

    @GetMapping("/publicacion/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publicacion showById(@PathVariable Long id) {
        return publicacionService.findById(id);
    }
}
