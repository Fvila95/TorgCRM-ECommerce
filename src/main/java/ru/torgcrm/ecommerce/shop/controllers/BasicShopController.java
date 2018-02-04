package ru.torgcrm.ecommerce.shop.controllers;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import ru.torgcrm.ecommerce.shop.config.RequestDataHolder;

public class BasicShopController {
    @Autowired @Getter
    private RequestDataHolder requestDataHolder;

    /**
     * Feel model with required attributes
     * @param model view model
     */
    protected void feelModel(Model model) {
        model.addAttribute("categories", getRequestDataHolder().getCategories());
        model.addAttribute("domain", getRequestDataHolder().getDomain());
        model.addAttribute("menu", getRequestDataHolder().getMenu());
    }
}
