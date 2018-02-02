package ru.torgcrm.ecommerce.shop.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.torgcrm.ecommerce.shop.repository.ItemRepository;

import javax.annotation.PostConstruct;

@Component
public class StartapUnit {

    @Value("${shop.generated_test_data}")
    private boolean generateTestData;
    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        if (generateTestData) {
            DataSeeder seeder = new DataSeeder();
            seeder.seedItems(50, itemRepository);
        }
    }
}
