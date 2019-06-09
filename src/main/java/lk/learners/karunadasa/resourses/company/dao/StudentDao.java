package lk.learners.karunadasa.resourses.company.dao;

import lk.learners.karunadasa.resourses.company.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface StudentDao extends JpaRepository<Student, Integer> {
    Student findFirstByOrderByIdDesc();

    Student findByNic(String nic);

    Student findByNumber(String number);
}
