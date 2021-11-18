package demo.spring.service;

import demo.spring.model.Role;
import demo.spring.model.RoleName;

public interface RoleService {
    void add(Role role);
  
    Role getRoleByName(RoleName roleName);
}
