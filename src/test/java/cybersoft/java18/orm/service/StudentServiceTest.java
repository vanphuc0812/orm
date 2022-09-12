package cybersoft.java18.orm.service;

import cybersoft.java18.orm.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService sut;
    @Test
    void shouldSaveStudent(){
        sut.save(Student.builder()
                .name("Student Test")
                .studentId(1)
                .build()
        );
    }
}
