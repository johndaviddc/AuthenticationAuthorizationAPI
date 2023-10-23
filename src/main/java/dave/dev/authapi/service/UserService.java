package dave.dev.authapi.service;

import dave.dev.authapi.model.Role;
import dave.dev.authapi.model.User;
import dave.dev.authapi.repository.RoleRepository;
import dave.dev.authapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String username, String password, Set<Role> roles) {
        User user = new User(username, passwordEncoder.encode(password));
        user.setRoles(roles);

        return userRepository.save(user);
    }
}
