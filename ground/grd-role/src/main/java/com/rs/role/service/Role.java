package com.rs.role.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Role {
    private List<String> roles;
    private String id;
}
