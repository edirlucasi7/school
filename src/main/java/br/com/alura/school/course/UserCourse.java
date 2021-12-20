package br.com.alura.school.course;

import br.com.alura.school.user.User;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users_course")
class UserCourse {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    private LocalDate date = LocalDate.now();

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne
    private Course course;

    @Deprecated
    protected UserCourse() { }

    UserCourse(User user, Course course) {
        Assert.notNull(user, "The user should not be null!");
        Assert.notNull(course, "The course should not be null!");
        this.user = user;
        user.addEnroll();
        this.course = course;
    }

    User getUser() { return user; }

    void setCourse(Course course) { this.course = course; }

}
