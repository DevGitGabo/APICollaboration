package pe.edu.utp.apicollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.entity.Insignia;
import pe.edu.utp.apicollaboration.service.IInsignia;

@RestController
@RequestMapping("/api/v1")
public class InsigniaController {

    @Autowired
    private IInsignia insigniaService;

    @PostMapping("/insignia")
    @ResponseStatus(HttpStatus.CREATED)
    public Insignia create(@RequestBody Insignia insignia) {
        return insigniaService.save(insignia);
    }

    @PutMapping("/insignia")
    @ResponseStatus(HttpStatus.CREATED)
    public Insignia update(@RequestBody Insignia insignia) {
        return insigniaService.save(insignia);
    }

    @DeleteMapping("/insignia/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Insignia insignia = insigniaService.findById(id);
        insigniaService.delete(insignia);
    }

    @GetMapping("/insignia/{id}")
    @ResponseStatus(HttpStatus.OK   )
    public Insignia showById(@PathVariable Long id) {
        return insigniaService.findById(id);
    }
}
