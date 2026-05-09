package com.social.media.controllers;

import com.social.media.models.SocialUser;
import com.social.media.services.SocialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {
    private final SocialService socialService;

    public SocialController(SocialService socialService) {
        this.socialService = socialService;
    }

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getAllUsers() {
        return ResponseEntity.ok(socialService.getAllUsers());
    }

    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> createUser(@RequestBody SocialUser socialUser) {
        return ResponseEntity.status(HttpStatus.CREATED).body(socialService.createUser(socialUser));
    }

    @DeleteMapping("/social/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        socialService.deleteUser(userId);
        return ResponseEntity.ok("User has been deleted");
    }
}
