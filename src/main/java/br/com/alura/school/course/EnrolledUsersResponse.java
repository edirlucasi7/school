package br.com.alura.school.course;

import br.com.alura.school.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

public class EnrolledUsersResponse {

    @JsonProperty
    private final String email;

    @JsonProperty(value = "amount_enroll")
    private final Integer amountEnroll;

    EnrolledUsersResponse(User user) {
        this.email = user.getEmail();
        this.amountEnroll = user.getAmountEnroll();
    }

    static Page<br.com.alura.school.course.EnrolledUsersResponse> convert(Page<User> users) {
        return users.map(br.com.alura.school.course.EnrolledUsersResponse::new);
    }

    String getEmail() {
        return email;
    }

    Integer getQuantidadeMatriculas() {
        return amountEnroll;
    }

}
