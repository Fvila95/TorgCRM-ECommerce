package ru.torgcrm.ecommerce.shop.controllers.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.torgcrm.ecommerce.shop.models.Customer;
import ru.torgcrm.ecommerce.shop.models.Customer;
import ru.torgcrm.ecommerce.shop.repository.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/admin/customers")
public class AdminCustomerController extends AdminRestController<Customer> {
    @Autowired
    private CustomerRepository customerRepository;

    @CrossOrigin
    @GetMapping
    public @ResponseBody
    List<Customer> list() {
        return customerRepository.findAll();
    }

    @CrossOrigin
    @Override
    @PutMapping
    public @ResponseBody
    Customer create(@RequestBody Customer model) {
        return customerRepository.save(model);
    }

    @CrossOrigin
    @PostMapping
    public @ResponseBody
    Customer update(@RequestBody Customer Customer) {
        return customerRepository.save(Customer);
    }

    @CrossOrigin
    @Override
    @GetMapping("/details/{id}")
    public @ResponseBody
    Customer getById(@PathVariable(name = "id") Long id) {
        return customerRepository.findOne(id);
    }

    @CrossOrigin
    @Override
    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        customerRepository.delete(id);
    }
}
