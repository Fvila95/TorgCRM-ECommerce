package ru.torgcrm.ecommerce.shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class ProjectDTO {
    @JsonProperty("id")
    @Getter @Setter
    private Long id;
    @JsonProperty("domain")
    @Getter @Setter
    private String domain;
    @JsonProperty("template")
    @Getter @Setter
    private String template;
}
