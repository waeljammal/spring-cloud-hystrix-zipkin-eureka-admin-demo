package com.rs.role.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RoleService {
    @GetMapping("/roles/{id}")
    public Role getRolesForUser(@PathVariable String id) {
        return new Role(new ArrayList<String>() {{
            add("ROLE_USER");
            add("ROLE_ADMIN");
        }}, id);
    }
}
