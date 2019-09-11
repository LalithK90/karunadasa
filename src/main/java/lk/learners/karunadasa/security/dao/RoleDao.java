package lk.learners.karunadasa.security.dao;



import lk.learners.karunadasa.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface RoleDao extends JpaRepository< Role, Long> {
}
