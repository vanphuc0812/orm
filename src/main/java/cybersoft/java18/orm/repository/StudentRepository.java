package cybersoft.java18.orm.repository;

import cybersoft.java18.orm.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByName(String name);
    @Query(nativeQuery = true, value = """
        select student_id, name 
        from student s 
        where s.name like '%'||:letters||'%'
    """)
    List<Student> findByContainLetters(@Param("letters") String letters);
}
