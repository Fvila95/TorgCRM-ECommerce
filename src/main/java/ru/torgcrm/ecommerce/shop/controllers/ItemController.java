package ru.torgcrm.ecommerce.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController extends BasicShopController {
    @RequestMapping("/item/{slug}")
    public String itemDetails() {
        return "item/details";
    }
}
