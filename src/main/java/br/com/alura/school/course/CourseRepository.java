package br.com.alura.school.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByCode(String code);

    @Query(value = "SELECT EXISTS(SELECT 1 FROM users_course uc WHERE uc.user_id = :idUser " +
            "AND uc.course_id = :idCourse)", nativeQuery = true)
    Boolean hasEqualsUsersInACourse(Long idUser, Long idCourse);
}
