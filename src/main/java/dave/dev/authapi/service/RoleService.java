package dave.dev.authapi.service;

import dave.dev.authapi.model.Role;
import dave.dev.authapi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(String name, String description) {
        Role role = new Role(name, description);
        return roleRepository.save(role);
    }

    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
