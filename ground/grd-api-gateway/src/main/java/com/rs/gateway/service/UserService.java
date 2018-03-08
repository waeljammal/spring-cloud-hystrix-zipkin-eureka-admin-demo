package com.rs.gateway.service;

import com.rs.gateway.aggregate.UserProfileAggregate;
import com.rs.gateway.client.UserClient;
import com.rs.gateway.model.Roles;
import com.rs.gateway.model.User;
import com.rs.gateway.client.RoleClient;
import com.rs.gateway.util.ServiceUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@Slf4j
public class UserService {
    private final ServiceUtils util;
    private final RoleClient roleClient;
    private final UserClient userClient;

    public UserService(ServiceUtils util,
                       RoleClient roleClient,
                       UserClient userClient) {
        this.util = util;
        this.roleClient = roleClient;
        this.userClient = userClient;
    }

    @ApiOperation(value = "Get the logged in users profile")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = UserProfileAggregate.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @GetMapping("/user/profile")
    public ResponseEntity<UserProfileAggregate> getComposedMessage() throws ExecutionException, InterruptedException {
        String mockIdFromPrincipal = "aa-bb-cc";

        CompletableFuture<User> userFuture = supplyAsync(() -> userClient.getProfile(mockIdFromPrincipal));
        CompletableFuture<Roles> rolesFuture = supplyAsync(() -> roleClient.getRoles(mockIdFromPrincipal));
        
        return util.createOkResponse(new UserProfileAggregate(userFuture.get(), rolesFuture.get().getRoles()));
    }
}
