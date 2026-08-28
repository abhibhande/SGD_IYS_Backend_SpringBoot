package com.SGD.IYS_Backend.auth.util;

import com.SGD.IYS_Backend.auth.OAuthService.AuthProvider;
import com.SGD.IYS_Backend.entity.IYSUser;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public IYSUser toIYSUser(PasswordEncoder passwordEncoder) {
        return new IYSUser(username, passwordEncoder.encode(password), fullname, street, city, state, zip, phone, AuthProvider.LOCAL);
    }


}
