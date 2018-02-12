package ru.torgcrm.ecommerce.shop.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsDTO extends User {

    private ru.torgcrm.ecommerce.shop.models.User user;

    public UserDetailsDTO(ru.torgcrm.ecommerce.shop.models.User user) {
        super(user.getEmail(), user.getPassword(), Collections.emptyList());
        this.user = user;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = this.user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
        return authorities;
    }

}
