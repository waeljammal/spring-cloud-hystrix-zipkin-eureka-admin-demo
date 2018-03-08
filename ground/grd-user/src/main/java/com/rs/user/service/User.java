package com.rs.user.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class User {
    private String id;
    private String firstName;
    private String lastName;
}
