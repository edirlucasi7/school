package br.com.alura.school.course;

import br.com.alura.school.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users_course")
public class UserCourse {

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
    public UserCourse() { }

    public UserCourse(User user, Course course) {
        this.user = user;
        this.course = course;
    }

    public User getUser() { return user; }

    public void setCourse(Course course) { this.course = course; }

}
