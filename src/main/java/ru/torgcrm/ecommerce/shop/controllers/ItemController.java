package ru.torgcrm.ecommerce.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.torgcrm.ecommerce.shop.models.Item;
import ru.torgcrm.ecommerce.shop.repository.ItemRepository;

@Controller
public class ItemController extends BasicShopController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping("/item/{slug}")
    public String itemDetails(@PathVariable(name = "slug") String slug,
                              Model model) {
        Item item = (Item) itemRepository.findBySlug(slug);
        model.addAttribute("item", item);
        model.addAttribute("categories", getRequestDataHolder().getCategories());
        model.addAttribute("domain", getRequestDataHolder().getDomain());
        return "item/details";
    }
}
