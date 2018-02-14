package ru.torgcrm.ecommerce.shop.controllers.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.torgcrm.ecommerce.shop.models.Item;
import ru.torgcrm.ecommerce.shop.repository.ItemRepository;

import java.util.List;

@RestController
@RequestMapping("/api/admin/items")
public class AdminItemsController extends AdminRestController<Item> {
    @Autowired
    private ItemRepository itemRepository;

    @CrossOrigin
    @GetMapping
    public @ResponseBody
    List<Item> list() {
        return itemRepository.findAll();
    }

    @CrossOrigin
    @Override
    @PutMapping
    public @ResponseBody
    Item create(@RequestBody Item model) {
        return itemRepository.save(model);
    }

    @CrossOrigin
    @PostMapping
    public @ResponseBody
    Item update(@RequestBody Item Item) {
        return itemRepository.save(Item);
    }

    @CrossOrigin
    @Override
    @GetMapping("/details/{id}")
    public @ResponseBody
    Item getById(@PathVariable(name = "id") Long id) {
        return itemRepository.findOne(id);
    }

    @CrossOrigin
    @Override
    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        itemRepository.delete(id);
    }
}
