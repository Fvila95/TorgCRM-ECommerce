package ru.torgcrm.ecommerce.shop.controllers.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.torgcrm.ecommerce.shop.models.Menu;
import ru.torgcrm.ecommerce.shop.repository.MenuRepository;

import java.util.List;

@RestController
@RequestMapping("/api/admin/menu")
public class AdminMenuController extends AdminRestController<Menu> {
    @Autowired
    private MenuRepository menuRepository;

    @CrossOrigin
    @GetMapping
    public @ResponseBody
    List<Menu> list() {
        return menuRepository.findAll();
    }

    @CrossOrigin
    @Override
    @PutMapping
    public @ResponseBody Menu create(@RequestBody Menu model) {
        return menuRepository.save(model);
    }

    @CrossOrigin
    @PostMapping
    public @ResponseBody Menu update(@RequestBody Menu menu) {
        return menuRepository.save(menu);
    }

    @CrossOrigin
    @Override
    @GetMapping("/details/{id}")
    public @ResponseBody Menu getById(@PathVariable(name = "id") Long id) {
        return menuRepository.findOne(id);
    }

    @CrossOrigin
    @Override
    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        menuRepository.delete(id);
    }
}
