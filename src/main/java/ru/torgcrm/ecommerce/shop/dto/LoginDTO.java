package ru.torgcrm.ecommerce.shop.dto;

import lombok.Getter;
import lombok.Setter;

public class LoginDTO {
    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private Boolean rememberMe;
}
