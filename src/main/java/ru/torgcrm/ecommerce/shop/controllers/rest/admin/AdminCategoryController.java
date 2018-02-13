package ru.torgcrm.ecommerce.shop.controllers.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.torgcrm.ecommerce.shop.models.Category;
import ru.torgcrm.ecommerce.shop.repository.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/admin/categories")
public class AdminCategoryController extends AdminRestController<Category> {
    @Autowired
    private CategoryRepository categoryRepository;

    @CrossOrigin
    @GetMapping
    public @ResponseBody
    List<Category> list() {
        return categoryRepository.findAll();
    }

    @CrossOrigin
    @Override
    @PutMapping
    public @ResponseBody
    Category create(@RequestBody Category model) {
        return categoryRepository.save(model);
    }

    @CrossOrigin
    @PostMapping
    public @ResponseBody
    Category update(@RequestBody Category Category) {
        return categoryRepository.save(Category);
    }

    @CrossOrigin
    @Override
    @GetMapping("/details/{id}")
    public @ResponseBody
    Category getById(@PathVariable(name = "id") Long id) {
        return categoryRepository.findOne(id);
    }

    @CrossOrigin
    @Override
    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        categoryRepository.delete(id);
    }
}
