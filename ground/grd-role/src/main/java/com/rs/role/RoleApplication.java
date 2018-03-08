package com.rs.role;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class RoleApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RoleApplication.class).run(args);
    }
}
