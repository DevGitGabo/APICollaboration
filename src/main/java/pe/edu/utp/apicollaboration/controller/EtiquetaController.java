package pe.edu.utp.apicollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.entity.Etiqueta;
import pe.edu.utp.apicollaboration.service.IEtiqueta;

@RestController
@RequestMapping("/api/v1")
public class EtiquetaController {

    @Autowired
    private IEtiqueta etiquetaService;

    @PostMapping("/etiqueta")
    @ResponseStatus(HttpStatus.CREATED)
    public Etiqueta create(@RequestBody Etiqueta etiqueta) {
        return etiquetaService.save(etiqueta);
    }

    @PutMapping("/etiqueta")
    @ResponseStatus(HttpStatus.CREATED)
    public Etiqueta update(@RequestBody Etiqueta etiqueta) {
        return etiquetaService.save(etiqueta);
    }

    @DeleteMapping("/etiqueta/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Etiqueta etiqueta = etiquetaService.findById(id);
        etiquetaService.delete(etiqueta);
    }

    @GetMapping("/etiqueta/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Etiqueta showById(@PathVariable Long id) {
        return etiquetaService.findById(id);
    }
}
