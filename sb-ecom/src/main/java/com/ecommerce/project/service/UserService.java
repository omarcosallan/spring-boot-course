package com.ecommerce.project.service;

import com.ecommerce.project.payload.UserDTO;
import com.ecommerce.project.security.request.RegisterRequest;

public interface UserService {
    UserDTO register(RegisterRequest registerRequest);
}
