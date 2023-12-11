package fsin.uis.svt_project.services;

import fsin.uis.svt_project.models.Role;
import fsin.uis.svt_project.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleRepositoryServiceImpl implements RoleRepositoryService{

    private final RoleRepository roleRepository;

    @Autowired
    public RoleRepositoryServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByNameRole(String nameRole) {
        return roleRepository.findByNameRole(nameRole);
    }
}
