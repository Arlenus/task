package kz.raskaliyev.locationsystem.util;

import kz.raskaliyev.locationsystem.model.entity.User;
import kz.raskaliyev.locationsystem.service.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public PersonValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        try {
            personDetailsService.loadUserByUsername(user.getUserName());
        } catch (UsernameNotFoundException ignored) {
            return;
        }
        errors.rejectValue("username", "A person with this username already exists");
    }
}
