package com.SGD.IYS_Backend.announcements.controller;


import com.SGD.IYS_Backend.auth.util.RegistrationForm;
import com.SGD.IYS_Backend.repository.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepo userRepo,
                                  PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "Registration Endpoint";
    }

    @PostMapping
    public ResponseEntity<String> processRegistration(
            @RequestBody RegistrationForm form) {

        if (userRepo.existsByUsername(form.getUsername())) {
            return ResponseEntity.badRequest()
                    .body("Username already exists");
        }

        userRepo.save(form.toIYSUser(passwordEncoder));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User registered successfully");
    }
}