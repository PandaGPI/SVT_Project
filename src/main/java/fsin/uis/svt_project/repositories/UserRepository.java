package fsin.uis.svt_project.repositories;

import fsin.uis.svt_project.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByFirstName(String firstName);
    Optional<User> findByEmail(String email);
}
