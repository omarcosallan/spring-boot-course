package com.ecommerce.project.controller;

import com.ecommerce.project.payload.UserDTO;
import com.ecommerce.project.security.request.LoginRequest;
import com.ecommerce.project.security.request.RegisterRequest;
import com.ecommerce.project.security.response.UserInfoResponse;
import com.ecommerce.project.service.AuthService;
import com.ecommerce.project.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<UserInfoResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        UserInfoResponse userInfoResponse = authService.login(loginRequest);
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, userInfoResponse.getJwtCookie())
                .body(userInfoResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody RegisterRequest registerRequest) {
        UserDTO user = userService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
