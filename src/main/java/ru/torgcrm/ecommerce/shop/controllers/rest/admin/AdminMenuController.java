package ru.torgcrm.ecommerce.shop.controllers.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.torgcrm.ecommerce.shop.models.Menu;
import ru.torgcrm.ecommerce.shop.repository.MenuRepository;

import java.util.List;

@RestController
@RequestMapping("/api/admin/menu")
public class AdminMenuController {
    @Autowired
    private MenuRepository menuRepository;

    @CrossOrigin
    @GetMapping
    private @ResponseBody List<Menu> getAll() {
        return menuRepository.findAll();
    }

    @CrossOrigin
    @PostMapping
    private Menu update(Menu menu) {
        return menuRepository.save(menu);
    }
}
