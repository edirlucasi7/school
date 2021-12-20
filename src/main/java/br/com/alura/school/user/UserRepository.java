package br.com.alura.school.user;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    @Query(value = "SELECT * FROM user u WHERE amount_enroll > 0 ORDER BY amount_enroll DESC", nativeQuery = true)
    List<User> enrollUsersReport();
}
