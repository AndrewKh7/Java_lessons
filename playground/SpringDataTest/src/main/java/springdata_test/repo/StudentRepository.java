package springdata_test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import springdata_test.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
