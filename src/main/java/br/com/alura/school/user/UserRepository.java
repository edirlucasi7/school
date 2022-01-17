package br.com.alura.school.user;

import br.com.alura.school.user.vo.EnrollUsersReportVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    @Query(value = "SELECT new br.com.alura.school.user.vo.EnrollUsersReportVO("
            + "user.email, user.amountEnroll) FROM User user WHERE user.amountEnroll > 0 GROUP BY user.email ORDER BY amount_enroll DESC")
    List<EnrollUsersReportVO> enrollUsersReport();
}
