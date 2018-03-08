package com.rs.user.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {
    @GetMapping(value = "/profile/{id}")
    public User getUserProfile(@PathVariable final String id) {
        return new User(id, "Wael", "Jammal");
    }
}
