package SpringbootREST.restapp.repository;

import SpringbootREST.restapp.model.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<student, Long> {
}
