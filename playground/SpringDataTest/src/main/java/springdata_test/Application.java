package springdata_test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import springdata_test.config.SpringConfig;
import springdata_test.entity.Student;
import springdata_test.repo.StudentRepository;
import springdata_test.services.StudentService;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Application {

    public static void main(String... args) throws ParseException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentService studentService = context.getBean(StudentService.class);


    }

}
