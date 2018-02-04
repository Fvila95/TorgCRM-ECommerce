package ru.torgcrm.ecommerce.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.torgcrm.ecommerce.shop.session.CartHolder;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
public class CartController extends BasicShopController {
    @RequestMapping
    public String index(Model model, HttpServletRequest request) {
        feelModel(model);
        return getViewTemplate("cart/index");
    }
}
