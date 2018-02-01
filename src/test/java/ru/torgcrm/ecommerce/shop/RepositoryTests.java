package ru.torgcrm.ecommerce.shop;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.torgcrm.ecommerce.shop.models.Item;
import ru.torgcrm.ecommerce.shop.repository.ItemRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class RepositoryTests {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void testItemRepository() {
        String title = "Title";
        String description = "Description";

        Item i = new Item();
        i.setTitle(title);
        i.setDescription(description);
        
        itemRepository.save(i);
        List<Item> items = itemRepository.findAll();
        items.forEach(item -> {
            Assert.assertNotNull(i.getCreateDate());
            Assert.assertNotNull(i.getLastUpdateDate());
            Assert.assertEquals(i.getTitle(), title);
            Assert.assertEquals(i.getDescription(), description);
        });
    }
}
