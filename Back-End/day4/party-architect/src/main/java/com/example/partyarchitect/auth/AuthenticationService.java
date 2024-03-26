package com.example.partyarchitect.auth;

import com.example.partyarchitect.Model.User;
import com.example.partyarchitect.Model.enumerated.Role;
import com.example.partyarchitect.Repository.*;
import com.example.partyarchitect.Service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
        .name(request.getName())
        .email(request.getEmail())
        .pwd(passwordEncoder.encode(request.getPwd()))
        .role(request.getRole())
        .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
        .token(jwtToken)

        .build();
    }
   
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getName(),
                request.getPwd()
            )
        );
        var user = repository.findByName(request.getName()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).id(user.getId()).name(user.getName()).build();
    }
    
  
}