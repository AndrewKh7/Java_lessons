package springdata_test.services;

import springdata_test.entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    List<Student> findAll();
}
