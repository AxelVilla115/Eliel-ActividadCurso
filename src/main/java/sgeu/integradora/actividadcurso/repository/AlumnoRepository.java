package sgeu.integradora.actividadcurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgeu.integradora.actividadcurso.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
