package br.com.alura.school.user.validator;

import br.com.alura.school.user.NewUserRequest;
import br.com.alura.school.user.User;
import br.com.alura.school.user.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class VerifyDuplicateEmailValidator implements Validator {

    private final UserRepository repository;

    public VerifyDuplicateEmailValidator(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NewUserRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }
        NewUserRequest request = (NewUserRequest)target;
        Optional<User> user  = repository.findByEmail(request.getEmail());
        if(user.isPresent()) {
            errors.rejectValue("email",null,"The field in entity is unique");
        }
    }

}
