package br.com.alura.school.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Size(max=20)
    @NotBlank
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(name = "amount_enroll")
    private Long amountEnroll;

    @Deprecated
    protected User() {}

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.amountEnroll = 0l;
    }

    public void addEnroll() {
        this.amountEnroll += 1l;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Long getAmountEnroll() {
        return amountEnroll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    public Long getId() {
        return id;
    }
}
