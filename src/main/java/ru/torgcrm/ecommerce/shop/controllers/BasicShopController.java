package ru.torgcrm.ecommerce.shop.controllers;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import ru.torgcrm.ecommerce.shop.config.RequestDataHolder;

public class BasicShopController {
    @Autowired @Getter
    private RequestDataHolder requestDataHolder;
}
