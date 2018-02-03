package ru.torgcrm.ecommerce.shop;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.torgcrm.ecommerce.shop.models.*;
import ru.torgcrm.ecommerce.shop.repository.*;
import ru.torgcrm.ecommerce.shop.utils.DataSeeder;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTests {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    MenuItemRepository menuItemRepository;
    @Autowired
    NewsRepository newsRepository;
    @Autowired
    OrdersRepository ordersRepository;

    /**
     * Testing item repository
     */
    @Test
    public void testItemRepository() {
        DataSeeder seeder = new DataSeeder();
        seeder.seedItems(10, itemRepository);

        List<Item> selectedItems = itemRepository.findAll();
        selectedItems.forEach(item -> {
            checkBasicProperties(item);
            Assert.assertNotNull(item.getPrice());
        });
    }

    @Test
    public void testCategoryRepository() {
        DataSeeder seeder = new DataSeeder();
        seeder.seedCategory(10, categoryRepository);

        List<Category> categories = categoryRepository.findAll();
        categories.forEach(category -> checkBasicProperties(category));
    }

    @Test
    public void testMenuRepository() {
        DataSeeder seeder = new DataSeeder();
        seeder.seedCategory(10, categoryRepository);

        List<Category> categories = categoryRepository.findAll();
        categories.forEach(category -> checkBasicProperties(category));
    }

    @Test
    public void testMenuItemRepository() {
        DataSeeder seeder = new DataSeeder();
        seeder.seedMenuItem(10, categoryRepository);

        List<MenuItem> menuItems = menuItemRepository.findAll();
        menuItems.forEach(menuItem -> checkBasicProperties(menuItem));
    }

    @Test
    public void testNewsRepository() {
        DataSeeder seeder = new DataSeeder();
        seeder.seedNews(10, newsRepository);

        List<News> news = newsRepository.findAll();
        news.forEach(n -> checkBasicProperties(n));
    }

    @Test
    public void testOrdersRepository() {
        DataSeeder seeder = new DataSeeder();
        seeder.seedOrders(10, ordersRepository);

        List<Order> orders = ordersRepository.findAll();
        orders.forEach(order -> checkBasicProperties(order));
    }

    /**
     * Check basic fields of basic model
     * @param model the domain model
     */
    private void checkBasicProperties(BaseModel model) {
        Assert.assertNotNull(model.getId());
        Assert.assertNotNull(model.getCreateDate());
        Assert.assertNotNull(model.getLastUpdateDate());
        if (model instanceof SimplePage) {
            SimplePage page = (SimplePage) model;
            Assert.assertNotNull(page.getTitle());
            Assert.assertNotNull(page.getDescription());
        }

    }
}
