package br.com.alura.school.course;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewUserCourseRequest {

    @Size(max=20)
    @NotBlank
    @JsonProperty
    private String username;

    public void setUsername(String username) { this.username = username; }

    public String getUsername() { return username; }

}