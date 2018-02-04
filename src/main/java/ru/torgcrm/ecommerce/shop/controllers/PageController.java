package ru.torgcrm.ecommerce.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/page")
public class PageController extends BasicShopController {

    @Override
    public String index(Model model, HttpServletRequest request) {
        throw new NotImplementedException();
    }

    @RequestMapping("/{slug}")
    public String indexSlug(Model model, @PathVariable(name = "slug") String slug) {
        feelModel(model);
        return getViewTemplate("page");
    }
}
