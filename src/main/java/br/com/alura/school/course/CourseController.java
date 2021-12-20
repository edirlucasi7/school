package br.com.alura.school.course;

import br.com.alura.school.user.User;
import br.com.alura.school.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
class CourseController {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseController(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/courses")
    ResponseEntity<List<CourseResponse>> allCourses() {
        List<Course> courses = courseRepository.findAll();
        return ResponseEntity.ok(CourseResponse.convert(courses));
    }

    @GetMapping("/courses/{code}")
    ResponseEntity<CourseResponse> courseByCode(@PathVariable("code") String code) {
        Course course = courseRepository.findByCode(code).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, format("Course with code %s not found", code)));
        return ResponseEntity.ok(new CourseResponse(course));
    }

    @GetMapping("/courses/enroll/report")
    ResponseEntity<List<EnrolledUsersResponse>> reportByEnroll() {
        List<User> users = userRepository.enrollUsersReport();
        if(!users.isEmpty()) {
            return ResponseEntity.ok(EnrolledUsersResponse.convert(users));
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/courses")
    ResponseEntity<Void> newCourse(@RequestBody @Valid NewCourseRequest newCourseRequest) {
        courseRepository.save(newCourseRequest.toEntity());
        URI location = URI.create(format("/courses/%s", newCourseRequest.getCode()));
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/courses/{courseCode}/enroll")
    ResponseEntity<Void> newEnroll(@PathVariable("courseCode") String courseCode, @RequestBody @Valid NewUserCourseRequest newUserCourseRequest) {
        User user = userRepository.findByUsername(newUserCourseRequest.getUsername()).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, format("User with username %s not found", newUserCourseRequest.getUsername())));
        Course course = courseRepository.findByCode(courseCode).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, format("Course with code %s not found", courseCode)));
        if(!course.hasEqualsUsersInACourse(newUserCourseRequest.getUsername())) {
            course.addUser(new UserCourse(user, course));
            courseRepository.save(course);
            return ResponseEntity.created(null).build();
        }
        return ResponseEntity.badRequest().build();
    }

}
