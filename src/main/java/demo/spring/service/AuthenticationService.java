package demo.spring.service;

import demo.spring.model.Role;
import demo.spring.model.User;
import java.util.Set;

public interface AuthenticationService {
    User register(String email, String password, Set<Role> roles);
}
