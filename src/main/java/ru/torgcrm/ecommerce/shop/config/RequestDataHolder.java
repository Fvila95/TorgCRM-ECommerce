package ru.torgcrm.ecommerce.shop.config;

import lombok.Getter;
import lombok.Setter;
import ru.torgcrm.ecommerce.shop.models.Category;

import java.util.List;

public class RequestDataHolder {
    @Getter @Setter
    private String domain;
    @Getter @Setter
    private List<Category> categories;
}
