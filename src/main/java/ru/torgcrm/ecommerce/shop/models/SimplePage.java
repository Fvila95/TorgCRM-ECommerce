package ru.torgcrm.ecommerce.shop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SimplePage extends BaseModel {
    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    @Lob
    private String description;

    @Getter
    @Setter
    @Column(name = "slug", unique = true)
    private String slug;
}
