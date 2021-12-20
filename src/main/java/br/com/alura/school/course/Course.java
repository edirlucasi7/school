package br.com.alura.school.course;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
class Course {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Size(max=10)
    @NotBlank
    @Column(nullable = false, unique = true)
    private String code;

    @Size(max=20)
    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<UserCourse> users = new ArrayList<>();

    @Deprecated
    protected Course() { }

    Course(String code, String name, String description) {
        Assert.notNull(code,"The course should not be null!");
        Assert.notNull(name,"The user should not be null!");
        this.code = code;
        this.name = name;
        this.description = description;
    }

    void addUser(UserCourse user) {
        Assert.notNull(user,"The user should not be null!");
        user.setCourse(this);
        this.users.add(user);
    }

    boolean hasEqualsUsersInACourse(String username) {
        Assert.notNull(username,"The username should not be null!");
        return users.stream().anyMatch(u -> (u.getUser().getUsername().equals(username)));
    }

    String getCode() {
        return code;
    }

    String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return code.equals(course.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

}
