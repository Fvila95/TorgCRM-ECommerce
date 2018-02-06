package ru.torgcrm.ecommerce.shop.controllers;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import ru.torgcrm.ecommerce.shop.config.RequestDataHolder;

import javax.servlet.http.HttpServletRequest;

public abstract class BasicShopController {
    @Autowired
    @Getter
    private RequestDataHolder requestDataHolder;

    public abstract String index(Model model, HttpServletRequest request);

    /**
     * Feel model with required attributes
     *
     * @param model view model
     */
    protected void feelModel(Model model) {
        model.addAttribute("categories", getRequestDataHolder().getCategories());
        model.addAttribute("domain", getRequestDataHolder().getDomain());
        model.addAttribute("menu", getRequestDataHolder().getMenu());
        model.addAttribute("template", getRequestDataHolder().getTemplate());
    }

    /**
     * Get request template path
     *
     * @param path request view template
     * @return string with request template location
     */
    protected String getViewTemplate(String path) {
        return requestDataHolder.getTemplate() + "/" + path;
    }
}
