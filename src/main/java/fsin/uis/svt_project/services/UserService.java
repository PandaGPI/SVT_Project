package fsin.uis.svt_project.services;

import fsin.uis.svt_project.dtos.RegistrationUserDTO;
import fsin.uis.svt_project.models.User;
import fsin.uis.svt_project.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private UserRepositoryServiceImpl userRepositoryService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    @Autowired
    public void setUserRepositoryService(UserRepositoryServiceImpl userRepositoryService) {
        this.userRepositoryService = userRepositoryService;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepositoryService.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь '%s' не найден", email)
        ));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getNameRole())).collect(Collectors.toSet())
        );
    }

    public User createUser(RegistrationUserDTO registrationUserDTO) {
        User user = new User();
        user.setFirstName(registrationUserDTO.getFirstName());
        user.setLastName(registrationUserDTO.getLastName());
        user.setPosition(registrationUserDTO.getPosition());
        user.setEmail(registrationUserDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registrationUserDTO.getPassword()));
        user.setRoles(Set.of(roleService.getUserRole()));
        return userRepository.save(user);
    }
}
