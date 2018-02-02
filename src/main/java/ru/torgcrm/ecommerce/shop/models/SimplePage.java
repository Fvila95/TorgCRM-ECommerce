package ru.torgcrm.ecommerce.shop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SimplePage extends BaseModel {
    @Getter @Setter
    private String title;

    @Getter @Setter
    private String description;
}
