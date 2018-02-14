package ru.torgcrm.ecommerce.shop.controllers.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.torgcrm.ecommerce.shop.models.Order;
import ru.torgcrm.ecommerce.shop.repository.OrdersRepository;

import java.util.List;

@RestController
@RequestMapping("/api/admin/orders")
public class AdminOrderController extends AdminRestController<Order> {
    @Autowired
    private OrdersRepository ordersRepository;

    @CrossOrigin
    @GetMapping
    public @ResponseBody
    List<Order> list() {
        return ordersRepository.findAll();
    }

    @CrossOrigin
    @Override
    @PutMapping
    public @ResponseBody
    Order create(@RequestBody Order model) {
        return ordersRepository.save(model);
    }

    @CrossOrigin
    @PostMapping
    public @ResponseBody
    Order update(@RequestBody Order Order) {
        return ordersRepository.save(Order);
    }

    @CrossOrigin
    @Override
    @GetMapping("/details/{id}")
    public @ResponseBody
    Order getById(@PathVariable(name = "id") Long id) {
        return ordersRepository.findOne(id);
    }

    @CrossOrigin
    @Override
    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        ordersRepository.delete(id);
    }
}
