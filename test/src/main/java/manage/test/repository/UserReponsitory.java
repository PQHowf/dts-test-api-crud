package manage.test.repository;

import jakarta.transaction.Transactional;
import manage.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserReponsitory extends JpaRepository<User, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.Status = false WHERE u.ID = :id")
    int softDelete(@Param("id") Long id);

    boolean existsByUserName(String userName);

    Optional<User> findByUserName(String userName);
}
