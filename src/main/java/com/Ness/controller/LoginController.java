package com.Ness.controller;

import com.Ness.exceptions.UsernameAlreadyExistsException;
import com.Ness.model.Role;
import com.Ness.model.User;
import com.Ness.repository.UserRepository;
import com.Ness.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String viewHomePage() {
        return "/index";
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        try {
            insertPredefinedUser();
        } catch (UsernameAlreadyExistsException e) {
            e.getMessage();
        }

        return "../static/login";
    }

    private void insertPredefinedUser() throws UsernameAlreadyExistsException {

        String userData = "user";

        if (!checkIfUsernameAlreadyExists(userData)) {
            User user = new User();

            Role role = new Role();
            role.setName("USER");
            roleService.save(role);

            Set<Role> set = new HashSet<>();
            set.add(role);

            user.setUsername(userData);
            user.setPassword(passwordEncoder.encode(userData));
            user.setRoles(set);
            userRepository.save(user);
        } else
            throw new UsernameAlreadyExistsException(userData);

    }

    private boolean checkIfUsernameAlreadyExists(String username) {
        return userRepository.getUserByUsername(username).isPresent();
    }
}
