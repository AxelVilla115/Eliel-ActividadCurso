package sgeu.integradora.actividadcurso.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sgeu.integradora.actividadcurso.model.Curso;
import sgeu.integradora.actividadcurso.service.CursoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping()
    public ResponseEntity<List<Curso>> listar(){
        return ResponseEntity.ok(cursoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscar (@PathVariable Long id) {
        Optional<Curso> optionalCurso = cursoService.findById(id);
        if (optionalCurso.isPresent()){
            return ResponseEntity.ok(optionalCurso.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Curso> guardar (@RequestBody Curso curso){
        Curso cursoGuardado = cursoService.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar (@PathVariable long id, @RequestBody Curso curso){
        Optional<Curso> optionalCurso = cursoService.update(id, curso);
        if (optionalCurso.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(optionalCurso.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> eliminar(@PathVariable long id){
        boolean deleted = cursoService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
