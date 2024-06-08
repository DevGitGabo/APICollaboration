package pe.edu.utp.apicollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.entity.Seguidores;
import pe.edu.utp.apicollaboration.service.ISeguidores;

@RestController
@RequestMapping("/api/v1")
public class SeguidoresController {

    @Autowired
    private ISeguidores seguidoresService;

    @PostMapping("/seguidores")
    @ResponseStatus(HttpStatus.CREATED)
    public Seguidores create(@RequestBody Seguidores seguidores) {
        return seguidoresService.save(seguidores);
    }

    @PutMapping("/seguidores")
    @ResponseStatus(HttpStatus.CREATED)
    public Seguidores update(@RequestBody Seguidores seguidores) {
        return seguidoresService.save(seguidores);
    }

    @DeleteMapping("/seguidores/{idSeguidor}/{idSeguido}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long idSeguidor, @PathVariable Long idSeguido) {
        Seguidores seguidores = seguidoresService.findById(idSeguidor, idSeguido);
        seguidoresService.delete(seguidores);
    }

    @GetMapping("/seguidores/{idSeguidor}/{idSeguido}")
    @ResponseStatus(HttpStatus.OK)
    public Seguidores showById(@PathVariable Long idSeguidor, @PathVariable Long idSeguido) {
        return seguidoresService.findById(idSeguidor, idSeguido);
    }
}
