package com.rs.gateway.client;

import com.rs.gateway.model.Roles;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RoleClientFallback implements RoleClient {
    @Override
    public Roles getRoles(String userId) {
        return new Roles(new ArrayList<String>() {{
            add("ROLE_USER");
        }}, userId);
    }
}