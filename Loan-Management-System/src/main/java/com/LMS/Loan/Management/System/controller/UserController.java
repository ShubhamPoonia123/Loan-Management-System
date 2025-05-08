package com.LMS.Loan.Management.System.controller;

import com.LMS.Loan.Management.System.config.JwtUtil;
import com.LMS.Loan.Management.System.dto.APIResponseDTO;
import com.LMS.Loan.Management.System.entity.User;
import com.LMS.Loan.Management.System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            return ResponseEntity.badRequest().body("Username cannot be null or empty");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body("Password cannot be null or empty");
        }

        if (userRepository.existsByUsername(user.getUsername())) {
            APIResponseDTO apiResponseDTO = new APIResponseDTO ( 409,"Username already exists" );
            return ResponseEntity.status( HttpStatus.CONFLICT).body(apiResponseDTO);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        APIResponseDTO apiResponseDTO = new APIResponseDTO ( 201,"User registered successfully." );
        return ResponseEntity.status( HttpStatus.CREATED).body(apiResponseDTO);
    }


    @PostMapping("/login")
    public ResponseEntity<APIResponseDTO> login(@RequestBody User request) {
        User appUser = userRepository.findByUsername(request.getUsername());

        if (appUser == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new APIResponseDTO(401, "Invalid username"));
        }

        if (!passwordEncoder.matches(request.getPassword(), appUser.getPassword())) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new APIResponseDTO(401, "Invalid password"));
        }

        String token = jwtUtil.generateToken(request.getUsername());

        return ResponseEntity.ok(new APIResponseDTO(200, "Login successful. Token: " + token));
    }

}
