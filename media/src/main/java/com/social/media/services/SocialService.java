package com.social.media.services;

import com.social.media.models.SocialUser;
import com.social.media.repositories.SocialUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {
    private final SocialUserRepository socialUserRepository;

    public SocialService(SocialUserRepository socialUserRepository) {
        this.socialUserRepository = socialUserRepository;
    }
    public List<SocialUser> getAllUsers() {
        return socialUserRepository.findAll();
    }


    public SocialUser createUser(SocialUser socialUser) {
        return  socialUserRepository.save(socialUser);
    }
}
