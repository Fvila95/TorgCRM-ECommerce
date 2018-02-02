package ru.torgcrm.ecommerce.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.torgcrm.ecommerce.shop.models.Category;
import ru.torgcrm.ecommerce.shop.models.Item;
import ru.torgcrm.ecommerce.shop.repository.CategoryRepository;
import ru.torgcrm.ecommerce.shop.repository.ItemRepository;

import java.util.List;

@Controller
public class IndexController extends BasicShopController {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/")
    public String index(@RequestAttribute("domain") String domain, Model model) {
        List<Item> items = itemRepository.findAll();
        List<Category> categories = categoryRepository.findAll();

        model.addAttribute("items", items);
        model.addAttribute("categories", categories);
        model.addAttribute("domain", domain);
        return "index";
    }
}
