package com.rs.gateway.aggregate;

import com.rs.gateway.model.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class UserProfileAggregate {
    @ApiModelProperty(notes = "The users profile", required = true)
    private User user;
    @ApiModelProperty(notes = "The users role", required = true)
    private List<String> roles;
}
