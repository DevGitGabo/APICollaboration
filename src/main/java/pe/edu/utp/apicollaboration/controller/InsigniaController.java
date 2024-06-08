package pe.edu.utp.apicollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.entity.Insignia;
import pe.edu.utp.apicollaboration.service.IInsignia;

@RestController
@RequestMapping("/api/v1")
public class InsigniaController {

    @Autowired
    private IInsignia insigniaService;

    @PostMapping("/insignia")
    public Insignia create(@RequestBody Insignia insignia) {
        return insigniaService.save(insignia);
    }

    @PutMapping("/insignia")
    public Insignia update(@RequestBody Insignia insignia) {
        return insigniaService.save(insignia);
    }

    @DeleteMapping("/insignia/{id}")
    public void delete(@PathVariable Long id) {
        Insignia insignia = insigniaService.findById(id);
        insigniaService.delete(insignia);
    }

    @GetMapping("/insignia/{id}")
    public Insignia showById(@PathVariable Long id) {
        return insigniaService.findById(id);
    }
}
