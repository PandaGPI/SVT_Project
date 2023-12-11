package fsin.uis.svt_project.services;

import fsin.uis.svt_project.models.Role;

import java.util.Optional;

public interface RoleRepositoryService {
    Optional<Role> findByNameRole(String nameRole);
}
