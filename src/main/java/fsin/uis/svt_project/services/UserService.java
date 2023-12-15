package fsin.uis.svt_project.services;

import fsin.uis.svt_project.dtos.RegistrationUserDTO;
import fsin.uis.svt_project.models.User;
import fsin.uis.svt_project.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepositoryServiceImpl userRepositoryService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositoryService.findByFirstName(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь '%s' не найден", username)
        ));
        return new org.springframework.security.core.userdetails.User(
                user.getFirstName(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getNameRole())).collect(Collectors.toSet())
        );
    }

    public User createUser(RegistrationUserDTO registrationUserDTO) {
        User user = new User();
        user.setFirstName(registrationUserDTO.getFirstName());
        user.setEmail(registrationUserDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registrationUserDTO.getPassword()));
        user.setRoles(Set.of(roleService.getUserRole()));
        return userRepository.save(user);
    }
}
