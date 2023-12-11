package fsin.uis.svt_project.repositories;

import fsin.uis.svt_project.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByNameRole(String nameRole);
}
