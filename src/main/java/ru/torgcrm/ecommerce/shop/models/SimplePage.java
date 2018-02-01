package ru.torgcrm.ecommerce.shop.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplePage extends BaseModel {
    private String title;
    private String description;
}
