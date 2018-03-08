package com.rs.gateway.client;

import com.rs.gateway.model.Roles;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "grd-role", fallback = RoleClientFallback.class)
@Primary
public interface RoleClient {
    @RequestMapping(method = RequestMethod.GET, value = "/roles/{userId}")
    Roles getRoles(@PathVariable("userId") String userId);
}