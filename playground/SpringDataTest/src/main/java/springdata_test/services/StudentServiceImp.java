package springdata_test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springdata_test.entity.Student;
import springdata_test.repo.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
      Student s =  (Student) studentRepository.saveAndFlush(student);
      return s;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
