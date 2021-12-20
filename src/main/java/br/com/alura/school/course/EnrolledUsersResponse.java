package br.com.alura.school.course;

import br.com.alura.school.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class EnrolledUsersResponse {

    @JsonProperty
    private final String email;

    @JsonProperty(value = "amount_enroll")
    private final Integer amountEnroll;

    EnrolledUsersResponse(User user) {
        this.email = user.getEmail();
        this.amountEnroll = user.getAmountEnroll();
    }

    static List<EnrolledUsersResponse> convert(List<User> users) {
        return users.stream().map(EnrolledUsersResponse::new).collect(Collectors.toList());
    }

    String getEmail() {
        return email;
    }

    Integer getQuantidadeMatriculas() {
        return amountEnroll;
    }

}
