package ru.torgcrm.ecommerce.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/news")
public class NewsController extends BasicShopController {

    @Override
    @RequestMapping
    public String index(Model model, HttpServletRequest request) {
        feelModel(model);
        return getViewTemplate("news/index");
    }

    @RequestMapping("/{year:\\d{4}}/{month:\\d{2}}/{day:\\d{2}}/{slug}")
    public String details(Model model,
                          @PathVariable(name = "year") String year,
                          @PathVariable(name = "month") String month,
                          @PathVariable(name = "day") String day
                          ) {
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        feelModel(model);
        return getViewTemplate("news/details");
    }
}
