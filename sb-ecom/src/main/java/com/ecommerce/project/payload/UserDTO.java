package com.ecommerce.project.payload;

import com.ecommerce.project.model.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private Long userId;
    private String username;
    private String email;
    private Set<Role> roles;
}
