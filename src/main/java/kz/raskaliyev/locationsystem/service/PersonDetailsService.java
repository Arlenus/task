package kz.raskaliyev.locationsystem.service;

import kz.raskaliyev.locationsystem.model.entity.User;
import kz.raskaliyev.locationsystem.repository.UserRepository;
import kz.raskaliyev.locationsystem.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public PersonDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        if (user.isPresent()) {
            return new PersonDetails(user.get());
        }
        throw new UsernameNotFoundException("User not found!");
    }
}
