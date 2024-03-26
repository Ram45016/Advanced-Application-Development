package com.example.partyarchitect.Model.enumerated;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    ADMIN(Set.of(
        Permissions.ADMIN_READ,
        Permissions.ADMIN_UPDATE,
        Permissions.ADMIN_CREATE,
        Permissions.ADMIN_DELETE
    )),
    
    USER(Set.of(
        Permissions.USER_READ,
        Permissions.USER_UPDATE,
        Permissions.USER_CREATE,
        Permissions.USER_DELETE
    ));

    @Getter
    private final Set<Permissions> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toList());
        
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
