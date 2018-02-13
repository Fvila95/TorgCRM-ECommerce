package ru.torgcrm.ecommerce.shop.controllers.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.torgcrm.ecommerce.shop.models.News;
import ru.torgcrm.ecommerce.shop.repository.NewsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/admin/news")
public class AdminNewsController extends AdminRestController<News> {

    @Autowired
    private NewsRepository newsRepository;

    @GetMapping
    @Override
    public @ResponseBody
    List<News> list() {
        return newsRepository.findAll();
    }

    @Override
    @PutMapping
    public @ResponseBody
    News create(@RequestBody News model) {
        return newsRepository.save(model);
    }

    @PostMapping
    @Override
    public @ResponseBody
    News update(@RequestBody News model) {
        return newsRepository.save(model);
    }

    @Override
    @GetMapping("/details/{id}")
    public @ResponseBody
    News getById(@PathVariable(name = "id") Long id) {
        return newsRepository.findOne(id);
    }

    @Override
    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        newsRepository.delete(id);
    }
}
