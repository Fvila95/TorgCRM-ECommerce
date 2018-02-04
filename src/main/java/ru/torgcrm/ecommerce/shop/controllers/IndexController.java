package ru.torgcrm.ecommerce.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.torgcrm.ecommerce.shop.models.Item;
import ru.torgcrm.ecommerce.shop.repository.ItemRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController extends BasicShopController {
    @Autowired
    ItemRepository itemRepository;

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request) {
        System.out.println(getCartHolder().getCartItem());
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        feelModel(model);
        return getViewTemplate("index");
    }
}
