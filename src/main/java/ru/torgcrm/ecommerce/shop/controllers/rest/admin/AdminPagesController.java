package ru.torgcrm.ecommerce.shop.controllers.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.torgcrm.ecommerce.shop.models.Page;
import ru.torgcrm.ecommerce.shop.repository.PageRepository;

import java.util.List;

@RestController
@RequestMapping("/api/admin/pages")
public class AdminPagesController extends AdminRestController<Page> {

    @Autowired
    private PageRepository pageRepository;

    @GetMapping
    @Override
    public @ResponseBody
    List<Page> list() {
        return pageRepository.findAll();
    }

    @Override
    @PutMapping
    public @ResponseBody
    Page create(@RequestBody Page model) {
        return pageRepository.save(model);
    }

    @PostMapping
    @Override
    public @ResponseBody
    Page update(@RequestBody Page model) {
        return pageRepository.save(model);
    }

    @Override
    @GetMapping("/details/{id}")
    public @ResponseBody
    Page getById(@PathVariable(name = "id") Long id) {
        return pageRepository.findOne(id);
    }

    @Override
    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        pageRepository.delete(id);
    }
}
