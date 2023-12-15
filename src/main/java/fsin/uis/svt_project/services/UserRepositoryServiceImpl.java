package fsin.uis.svt_project.services;

import fsin.uis.svt_project.models.User;
import fsin.uis.svt_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService{

    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

}
