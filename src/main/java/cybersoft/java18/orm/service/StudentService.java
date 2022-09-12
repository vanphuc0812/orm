package cybersoft.java18.orm.service;

import cybersoft.java18.orm.model.Student;
import cybersoft.java18.orm.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();
    Optional<Student> findById(int id);
    Student save(Student student);

    @Transactional
    Student update(Student student, Integer id);

    List<Student> findByName(String name);

    List<Student> findByLetters(String letters);
}

@Service
class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;
    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Student> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    @Transactional
    public Student update(Student student, Integer id) {
        Student pStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student is not existed."));
        pStudent.setName(student.getName());
        return pStudent;
    }

    @Override
    public List<Student> findByName(String name) {
        return repository.findByName(name);
    }
    @Override
    public List<Student> findByLetters(String letters) {
        return repository.findByContainLetters(letters);
    }
}
