package ru.torgcrm.ecommerce.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
public class CartController extends BasicShopController {
    @RequestMapping
    public String index(Model model, HttpServletRequest request) {
        feelModel(model);
        return "cart";
    }
}
