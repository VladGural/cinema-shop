package demo.spring.controller;

import demo.spring.dto.request.UserRequestDto;
import demo.spring.dto.response.UserResponseDto;
import demo.spring.model.Role;
import demo.spring.model.RoleName;
import demo.spring.model.User;
import demo.spring.service.AuthenticationService;
import demo.spring.service.RoleService;
import demo.spring.service.mapper.UserMapper;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserMapper userMapper;
    private final RoleService roleService;

    public AuthenticationController(AuthenticationService authService,
                                    UserMapper userMapper,
                                    RoleService roleService) {
        this.authService = authService;
        this.userMapper = userMapper;
        this.roleService = roleService;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        Role userRole = roleService.getRoleByName(RoleName.USER);
        User user = authService.register(requestDto.getEmail(), requestDto.getPassword(),
                Set.of(userRole));
        return userMapper.mapToDto(user);
    }
}
