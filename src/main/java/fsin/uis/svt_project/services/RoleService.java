package fsin.uis.svt_project.services;

import fsin.uis.svt_project.models.Role;
import fsin.uis.svt_project.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

   private final RoleRepositoryServiceImpl roleRepositoryService;

   public Role getUserRole() {
       return roleRepositoryService.findByNameRole("ROLE_USER").get();
   }
}
