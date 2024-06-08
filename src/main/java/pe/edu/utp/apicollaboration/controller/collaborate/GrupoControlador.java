package pe.edu.utp.apicollaboration.controller.collaborate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.apicollaboration.model.dao.MiembroGrupoDao;
import pe.edu.utp.apicollaboration.model.dao.UsuarioDao;
import pe.edu.utp.apicollaboration.model.dto.grupo.GrupoDto;
import pe.edu.utp.apicollaboration.model.dto.grupo.NuevoGrupoDto;
import pe.edu.utp.apicollaboration.model.dto.miembroGrupo.MiembroGrupoDto;
import pe.edu.utp.apicollaboration.model.entity.Grupo;
import pe.edu.utp.apicollaboration.model.entity.MiembroGrupo;
import pe.edu.utp.apicollaboration.model.entity.Usuario;
import pe.edu.utp.apicollaboration.service.IGrupo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class GrupoControlador {
    @Autowired
    private IGrupo iGrupo;
    @Autowired
    private MiembroGrupoDao miembroGrupoDao;
    @GetMapping("Grupos/{id}")
    public ResponseEntity<List<GrupoDto>> getGrups(@PathVariable Long id) {
        List<Grupo> gruposDelUsuario = iGrupo.findGruposByUserId(id);

        List<GrupoDto> gruposForUser = new ArrayList<>();
        for (Grupo grupo : gruposDelUsuario) {
            List<MiembroGrupoDto> miembrosDelGrupo = miembroGrupoDao.miembrosGrupo(grupo.getIdGrupo());
            GrupoDto grupoDto = new GrupoDto(
                    grupo.getIdGrupo(),
                    grupo.getNombreGrupo(),
                    grupo.getNombreTarea(),
                    grupo.getCurso().getHorario(),
                    grupo.getCurso().getNombreCurso(),
                    grupo.getDescripcion(),
                    miembrosDelGrupo);
            gruposForUser.add(grupoDto);
        }

        return ResponseEntity.ok(gruposForUser);
    }

    @PostMapping("Grupos/newGroup")
    public ResponseEntity<?> createNewGrupo(@RequestBody NuevoGrupoDto nuevoGrupoDto){
        iGrupo.save(nuevoGrupoDto,nuevoGrupoDto.idsUsuarios());
        return ResponseEntity.status(HttpStatus.CREATED).body("Grupo creado exitosamente");
    }
}
