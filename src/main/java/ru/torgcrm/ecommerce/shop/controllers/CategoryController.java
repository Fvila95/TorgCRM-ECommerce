package ru.torgcrm.ecommerce.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.torgcrm.ecommerce.shop.models.Category;
import ru.torgcrm.ecommerce.shop.models.Item;
import ru.torgcrm.ecommerce.shop.repository.CategoryRepository;
import ru.torgcrm.ecommerce.shop.repository.ItemRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CategoryController extends BasicShopController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ItemRepository itemRepository;

    @Override
    @RequestMapping("/categories")
    public String index(Model modelAndView, HttpServletRequest request) {
        return "categories";
    }

    @RequestMapping("/category/{slug}")
    public String categoryIndex(@PathVariable(value = "slug") String slug,
                                Model model) {
        Category currentCategory = (Category) categoryRepository.findBySlug(slug);
        List<Item> items = itemRepository.findByCategoryId(currentCategory.getId());
        model.addAttribute("items", items);
        feelModel(model);
        return getViewTemplate("category/index");
    }

}
