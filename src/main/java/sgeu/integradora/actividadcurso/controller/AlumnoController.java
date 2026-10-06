package sgeu.integradora.actividadcurso.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sgeu.integradora.actividadcurso.model.Alumno;
import sgeu.integradora.actividadcurso.model.Curso;
import sgeu.integradora.actividadcurso.service.AlumnoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping()
    public ResponseEntity<List<Alumno>> listar(){
        return ResponseEntity.ok(alumnoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> buscar (@PathVariable Long id) {
        Optional<Alumno> optionalAlumno = alumnoService.findById(id);
        if (optionalAlumno.isPresent()){
            return ResponseEntity.ok(optionalAlumno.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Alumno> guardar (@RequestBody Alumno alumno){
        Alumno cursoGuardado = alumnoService.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizar (@PathVariable long id, @RequestBody Alumno alumno){
        Optional<Alumno> optionalAlumno = alumnoService.update(id, alumno);
        if (optionalAlumno.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(optionalAlumno.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Alumno> eliminar(@PathVariable long id){
        boolean deleted = alumnoService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
