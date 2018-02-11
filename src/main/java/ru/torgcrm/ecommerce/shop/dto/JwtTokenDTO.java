package ru.torgcrm.ecommerce.shop.dto;

import lombok.Getter;
import lombok.Setter;

public class JwtTokenDTO {
    @Getter
    @Setter
    private String token;

    public JwtTokenDTO(String token) {
        this.token = token;
    }

}
