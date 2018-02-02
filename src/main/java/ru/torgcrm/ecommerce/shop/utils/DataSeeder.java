package ru.torgcrm.ecommerce.shop.utils;

import com.github.javafaker.Faker;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.torgcrm.ecommerce.shop.models.Item;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataSeeder {

    public void seedItems(int quantity, JpaRepository repository) {
        Faker faker = new Faker(new Locale("ru"));
        List<Item> items = Stream.generate(Item::new)
                .limit(quantity)
                .collect(Collectors.toList());
        items.forEach(item -> {
            String title = faker.commerce().productName();
            String description = faker.lorem().paragraph();

            item.setTitle(title);
            item.setDescription(description);
            repository.save(item);
        });

    }
}
