package ru.torgcrm.ecommerce.shop.config;

import lombok.Getter;
import lombok.Setter;
import ru.torgcrm.ecommerce.shop.models.Category;
import ru.torgcrm.ecommerce.shop.models.Menu;

import java.util.List;
import java.util.Map;

public class RequestDataHolder {
    @Getter @Setter
    private String domain;
    @Getter @Setter
    private List<Category> categories;
    @Getter @Setter
    private Map<String, Menu> menu;
}
