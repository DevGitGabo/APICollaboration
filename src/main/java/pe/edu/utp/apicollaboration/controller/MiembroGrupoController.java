package pe.edu.utp.apicollaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.entity.MiembroGrupo;
import pe.edu.utp.apicollaboration.service.IMiembroGrupo;

@RestController
@RequestMapping("/api/v1")
public class MiembroGrupoController {

    @Autowired
    private IMiembroGrupo miembroGrupoService;

    @PostMapping("/miembroGrupo")
    public MiembroGrupo create(@RequestBody MiembroGrupo miembroGrupo) {
        return miembroGrupoService.save(miembroGrupo);
    }

    @PutMapping("/miembroGrupo")
    public MiembroGrupo update(@RequestBody MiembroGrupo miembroGrupo) {
        return miembroGrupoService.save(miembroGrupo);
    }

    @DeleteMapping("/miembroGrupo/{id}")
    public void delete(@PathVariable Long id) {
        MiembroGrupo miembroGrupo = miembroGrupoService.findById(id);
        miembroGrupoService.delete(miembroGrupo);
    }

    @GetMapping("/miembroGrupo/{id}")
    public MiembroGrupo showById(@PathVariable Long id) {
        return miembroGrupoService.findById(id);
    }
}
