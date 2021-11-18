package demo.spring.dao;

import demo.spring.model.Role;
import demo.spring.model.RoleName;
import java.util.Optional;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(RoleName roleName);
}
