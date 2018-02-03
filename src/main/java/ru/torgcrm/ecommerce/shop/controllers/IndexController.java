package ru.torgcrm.ecommerce.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.torgcrm.ecommerce.shop.interceptors.BasicShopInterceptor;
import ru.torgcrm.ecommerce.shop.models.Category;
import ru.torgcrm.ecommerce.shop.models.Item;
import ru.torgcrm.ecommerce.shop.repository.CategoryRepository;
import ru.torgcrm.ecommerce.shop.repository.ItemRepository;

import java.util.List;

@Controller
public class IndexController extends BasicShopController {
    @Autowired
    ItemRepository itemRepository;

    @RequestMapping("/")
    public String index(Model model) {
        List<Item> items = itemRepository.findAll();

        model.addAttribute("items", items);
        model.addAttribute("categories", getRequestDataHolder().getCategories());
        model.addAttribute("domain", getRequestDataHolder().getDomain());
        return "index";
    }
}
