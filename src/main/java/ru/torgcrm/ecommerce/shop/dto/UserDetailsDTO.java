package ru.torgcrm.ecommerce.shop.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsDTO extends User {

    private ru.torgcrm.ecommerce.shop.models.User user;

    public UserDetailsDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserDetailsDTO(ru.torgcrm.ecommerce.shop.models.User user) {
        super(user.getLogin(), user.getPassword(), user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList()));
    }

}
