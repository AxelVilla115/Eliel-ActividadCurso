package sgeu.integradora.actividadcurso.service;

import org.springframework.stereotype.Service;
import sgeu.integradora.actividadcurso.model.Curso;
import sgeu.integradora.actividadcurso.repository.CursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> findAll (){
        return cursoRepository.findAll();
    }

    public Optional<Curso> findById(Long id){
        return cursoRepository.findById(id);
    }

    public Curso save (Curso curso){
        return cursoRepository.save(curso);
    }

    public Optional<Curso> update (Long id, Curso curso){
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if (optionalCurso.isEmpty()){
            return Optional.empty();
        }
        Curso cursoDB = optionalCurso.get();

        cursoDB.setNombre(curso.getNombre());
        cursoDB.setHora_inicio(curso.getHora_inicio());
        cursoDB.setHora_final(curso.getHora_final());

        return Optional.of(cursoRepository.save(cursoDB));
    }

    public boolean delete (Long id){
        if (!cursoRepository.existsById(id)){
            return false;
        }
        cursoRepository.deleteById(id);
        return true;
    }
}
