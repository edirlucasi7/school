package br.com.alura.school.course;

import br.com.alura.school.support.validation.Unique;
import br.com.alura.school.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

class NewCourseUserRequest {

    @Size(max=20)
    @NotBlank
    @JsonProperty
    private String username;

    public void setUsername(String username) { this.username = username; }

    String getUsername() { return username; }

}
