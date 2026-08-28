package com.SGD.IYS_Backend.auth.OAuthService;

import com.SGD.IYS_Backend.entity.IYSUser;
import com.SGD.IYS_Backend.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepo userRepo;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest)
            throws OAuth2AuthenticationException {

        OAuth2User oauth2User = super.loadUser(userRequest);

        String email = oauth2User.getAttribute("email");
        String name = oauth2User.getAttribute("name");

        IYSUser user = userRepo.findByUsername(email);

        if (user == null) {

            user = new IYSUser(
                    email,
                    "GOOGLE_USER",
                    name,
                    "",
                    "",
                    "",
                    "",
                    "",
                    AuthProvider.GOOGLE
            );

        } else {

            user.setFullname(name);
        }

        userRepo.save(user);


        return oauth2User;
    }
}
