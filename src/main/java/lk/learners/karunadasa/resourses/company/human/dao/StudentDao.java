package lk.learners.karunadasa.resourses.company.human.dao;

import lk.learners.karunadasa.resourses.company.human.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface StudentDao extends JpaRepository<Student, Long> {
    Student findFirstByOrderByIdDesc();

    Student findByNic(String nic);

    Student findByNumber(String number);
}
