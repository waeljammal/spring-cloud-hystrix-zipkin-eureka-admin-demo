package com.rs.gateway.client;

import com.rs.gateway.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("grd-user")
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "/profile/{userId}")
    User getProfile(@PathVariable("userId") String userId);
}