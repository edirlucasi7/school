package br.com.alura.school.course;

import br.com.alura.school.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserCourseTest {

    @Test
    void should_create_new_user_in_course() throws Exception {
        User user = new User("icety", "icety@email.com");
        Course course = new Course("java-1", "Java OO", "Java and Object Orientation: Encapsulation, Inheritance and Polymorphism.");

        UserCourse userCourse = new UserCourse(user, course);

        Assertions.assertNotNull(userCourse);
    }

    @Test
    void should_add_enrollment_in_user() throws Exception {
        User user = new User("icety", "icety@email.com");
        Course course = new Course("java-1", "Java OO", "Java and Object Orientation: Encapsulation, Inheritance and Polymorphism.");

        UserCourse userCourse = new UserCourse(user, course);

        Assertions.assertEquals(1, user.getAmountEnroll());
    }

}
