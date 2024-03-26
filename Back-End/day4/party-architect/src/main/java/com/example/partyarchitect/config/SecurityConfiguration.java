package com.example.partyarchitect.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.partyarchitect.Model.enumerated.Permissions;
import com.example.partyarchitect.Model.enumerated.Role;
import com.example.partyarchitect.utils.MyConstant;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JWTAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       http
       .csrf(csrf -> csrf.disable())
      .authorizeHttpRequests(authorize -> authorize.requestMatchers(MyConstant.WHITELIST_URL).permitAll()
       .requestMatchers("/api/v1/***").hasAnyRole(Role.ADMIN.name(),Role.USER.name())
       .requestMatchers(GET,"/api/v1/**").hasAnyAuthority(Permissions.ADMIN_READ.name(),Permissions.USER_READ.name())
       .requestMatchers(POST,"/api/v1/**").hasAnyAuthority(Permissions.ADMIN_CREATE.name(),Permissions.USER_CREATE.name())
       .requestMatchers(PUT,"/api/v1/**").hasAnyAuthority(Permissions.ADMIN_UPDATE.name(),Permissions.USER_UPDATE.name())
       .requestMatchers(DELETE,"/api/v1/**").hasAnyAuthority(Permissions.ADMIN_DELETE.name(),Permissions.USER_DELETE.name())
       .requestMatchers("/api/v1/***").hasRole(Role.ADMIN.name())
       .requestMatchers(GET,"/api/v1/**").hasAuthority(Permissions.ADMIN_READ.name())
       .requestMatchers(POST,"/api/v1/**").hasAuthority(Permissions.ADMIN_CREATE.name())
       .requestMatchers(PUT,"/api/v1/**").hasAuthority(Permissions.ADMIN_UPDATE.name())
       .requestMatchers(DELETE,"/api/v1/**").hasAuthority(Permissions.ADMIN_DELETE.name())
       .anyRequest().authenticated())
       .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
       .authenticationProvider(authenticationProvider)
       .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }

}
