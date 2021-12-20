package br.com.alura.school.course;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NewCourseRequestTest {

    @Test
    void should_create_new_course() throws Exception {
        NewCourseRequest newCourseRequest = new NewCourseRequest("java-2", "Java Collections", "Java Collections: Lists, Sets, Maps and more.");

        Course course = newCourseRequest.toEntity();

        Assertions.assertNotNull(course);
    }

}
