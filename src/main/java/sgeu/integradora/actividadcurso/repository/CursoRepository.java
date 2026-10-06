package sgeu.integradora.actividadcurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgeu.integradora.actividadcurso.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
