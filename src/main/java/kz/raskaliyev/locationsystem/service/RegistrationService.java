package kz.raskaliyev.locationsystem.service;

import kz.raskaliyev.locationsystem.model.entity.User;
import kz.raskaliyev.locationsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
    private final UserRepository userRepository;


    @Autowired
    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public void registerUser(User user){
        userRepository.save(user);
    }
}
