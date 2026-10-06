package sgeu.integradora.actividadcurso.service;

import org.springframework.stereotype.Service;
import sgeu.integradora.actividadcurso.model.Alumno;
import sgeu.integradora.actividadcurso.model.Curso;
import sgeu.integradora.actividadcurso.repository.AlumnoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> findAll (){
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> findById(Long id){
        return alumnoRepository.findById(id);
    }

    public Alumno save (Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    public Optional<Alumno> update (Long id, Alumno alumno){
        Optional<Alumno> optionalCurso = alumnoRepository.findById(id);
        if (optionalCurso.isEmpty()){
            return Optional.empty();
        }
        Alumno alumnoDB = optionalCurso.get();

        alumnoDB.setNombre(alumno.getNombre());
        alumnoDB.setApellido_paterno(alumno.getApellido_paterno());
        alumnoDB.setEdad(alumno.getEdad());
        alumnoDB.setCorreo(alumno.getCorreo());

        return Optional.of(alumnoRepository.save(alumnoDB));
    }

    public boolean delete (Long id){
        if (!alumnoRepository.existsById(id)){
            return false;
        }
        alumnoRepository.deleteById(id);
        return true;
    }
}
