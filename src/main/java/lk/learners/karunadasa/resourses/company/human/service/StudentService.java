package lk.learners.karunadasa.resourses.company.human.service;

import java.util.List;
import lk.learners.karunadasa.resourses.company.human.dao.StudentDao;
import lk.learners.karunadasa.resourses.company.human.entity.Student;
import lk.learners.karunadasa.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
@Transactional
public class StudentService implements AbstractService<Student, Long>
{
    private final StudentDao StudentDao;

    @Autowired
    public StudentService(StudentDao StudentDao)
    {
        this.StudentDao = StudentDao;
    }

    public List<Student> findAll()
    {
        return StudentDao.findAll();
    }

    public Student findById(Long id)
    {
        return (Student)StudentDao.getOne(id);
    }

    public Student persist(Student Student)
    {
        return (Student)StudentDao.save(Student);
    }

    public boolean delete(Long id)
    {
        StudentDao.deleteById(id);
        return false;
    }




    public List<Student> search(Student Student)
    {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Student> StudentExample = Example.of(Student, matcher);
        return StudentDao.findAll(StudentExample);
    }

    public Student lastStudent()
    {
        return StudentDao.findFirstByOrderByIdDesc();
    }

    public Student findByNIC(String nic)
    {
        return StudentDao.findByNic(nic);
    }

    public Student findByNumber(String number) {
        return StudentDao.findByNumber(number);
    }
}