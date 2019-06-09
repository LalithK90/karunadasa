package lk.learners.karunadasa.Security.dao;



import lk.learners.karunadasa.Security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface RoleDao extends JpaRepository<Role, Integer> {
}
