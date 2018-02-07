package ru.torgcrm.ecommerce.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.torgcrm.ecommerce.shop.config.SessionDataHolder;
import ru.torgcrm.ecommerce.shop.dto.CartObjectDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController extends BasicShopController {
    @Autowired
    SessionDataHolder sessionDataHolder;

    @RequestMapping
    public String index(Model model, HttpServletRequest request) {
        List<CartObjectDTO> cartObjects = sessionDataHolder.getCartObjects();
        feelModel(model);

        model.addAttribute("cartObjects", cartObjects);
        return getViewTemplate("cart/index");
    }
}
