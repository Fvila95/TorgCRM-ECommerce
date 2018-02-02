package ru.torgcrm.ecommerce.shop.utils;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.torgcrm.ecommerce.shop.models.Item;
import ru.torgcrm.ecommerce.shop.repository.ItemRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class StartapUnit {

    @Value("${shop.generated_test_data}")
    private boolean generateTestData;
    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        if (generateTestData) {
            Faker faker = new Faker(new Locale("ru"));

            List<Item> items = Stream.generate(Item::new)
                    .limit(10)
                    .collect(Collectors.toList());
            items.forEach(item -> {
                String title = faker.commerce().productName();
                String description = faker.lorem().paragraph();

                item.setTitle(title);
                item.setDescription(description);
                itemRepository.save(item);
            });
        }
    }
}
