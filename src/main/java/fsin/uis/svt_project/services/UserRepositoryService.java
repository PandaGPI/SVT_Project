package fsin.uis.svt_project.services;

import fsin.uis.svt_project.models.User;

import java.util.Optional;

public interface UserRepositoryService {

    Optional<User> findByFirstName(String firstName);
}
