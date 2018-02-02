package ru.torgcrm.ecommerce.shop;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.torgcrm.ecommerce.shop.models.Item;
import ru.torgcrm.ecommerce.shop.repository.ItemRepository;
import ru.torgcrm.ecommerce.shop.utils.DataSeeder;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class RepositoryTests {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void testItemRepository() {
        Faker faker = new Faker(new Locale("ru"));

        DataSeeder seeder = new DataSeeder();
        seeder.seedItems(50, itemRepository);

        List<Item> selectedItems = itemRepository.findAll();
        selectedItems.forEach(item -> {
            Assert.assertNotNull(item.getCreateDate());
            Assert.assertNotNull(item.getLastUpdateDate());
            Assert.assertNotNull(item.getTitle());
            Assert.assertNotNull(item.getDescription());
        });
    }
}
