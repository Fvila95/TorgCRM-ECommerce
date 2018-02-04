package ru.torgcrm.ecommerce.shop.utils;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.torgcrm.ecommerce.shop.models.*;
import ru.torgcrm.ecommerce.shop.repository.*;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataSeeder {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ResponseRepository responseRepository;

    /**
     * Populate items table
     *
     * @param quantity total quantity of generated items
     */
    public void seedItems(int quantity) {
        List<Item> items = Stream.generate(Item::new)
                .limit(quantity)
                .collect(Collectors.toList());
        items.forEach((Item item) -> {
            seedSimplePageData(item);
            item.setPrice(2.0);
            save(itemRepository, item);
        });
    }

    /**
     * Populate items with categories
     *
     * @param quantity total quantity of generated items
     */
    public void seedItemsWithCategories(int quantity, List<Category> categories) {
        List<Item> items = Stream.generate(Item::new)
                .limit(quantity)
                .collect(Collectors.toList());
        items.forEach((Item item) -> {
            Random random = new Random();
            int randomNumber = random.nextInt(categories.size());

            seedSimplePageData(item);
            item.setPrice(2.0);
            item.setCategory(categories.get(randomNumber));
            save(itemRepository, item);
        });
    }

    /**
     * Populate category
     *
     * @param quantity quantity of generated categories
     */
    public void seedCategory(int quantity) {
        List<Category> categories = Stream.generate(Category::new)
                .limit(quantity)
                .collect(Collectors.toList());
        categories.forEach(category -> {
            seedSimplePageData(category);
            save(categoryRepository, category);
        });
    }

    /**
     * Populate menu
     */
    public void seedMenu() {
        Menu menu = new Menu();
        menu.setCode("main_menu");
        menu.setTitle("Main menu");
        menuRepository.save(menu);
    }

    /**
     * Populate menu item
     *
     * @param quantity quantity of generated menu items
     */
    public void seedMenuItem(int quantity) {
        List<MenuItem> menus = Stream.generate(MenuItem::new)
                .limit(quantity)
                .collect(Collectors.toList());
        Menu menu = menuRepository.findByCode("main_menu");
        menus.forEach(menuItem -> {
            Faker faker = new Faker();
            menuItem.setTitle(faker.app().name());
            menuItem.setCode(faker.app().name());
            menuItem.setLink("/page/sample");
            menuItem.setMenu(menu);
            save(menuItemRepository, menuItem);
        });
    }

    /**
     * Populate menu item
     *
     * @param quantity quantity of generated menu items
     */
    public void seedNews(int quantity) {
        List<News> news = Stream.generate(News::new)
                .limit(quantity)
                .collect(Collectors.toList());
        news.forEach(n -> {
            seedSimplePageData(n);
            save(newsRepository, n);
        });
    }

    /**
     * Populate menu item
     *
     * @param quantity quantity of generated menu items
     */
    public void seedOrders(int quantity) {
        List<Order> orders = Stream.generate(Order::new)
                .limit(quantity)
                .collect(Collectors.toList());
        orders.forEach(order -> save(ordersRepository, order));
    }

    /**
     * Populate menu item
     *
     * @param quantity quantity of generated menu items
     */
    public void seedResponses(int quantity) {
        List<Response> responses = Stream.generate(Response::new)
                .limit(quantity)
                .collect(Collectors.toList());
        responses.forEach(response -> {
            Faker faker = new Faker(new Locale("ru"));
            response.setResponse(faker.lorem().sentence(10));
            response.setCustomerName(faker.name().fullName());
            save(responseRepository, response);
        });
    }

    /**
     * Generate basic simple page fake data
     *
     * @param page simple page entity
     * @return simple page entity
     */
    private void seedSimplePageData(SimplePage page) {
        Faker faker = new Faker(new Locale("ru"));
        String title = faker.commerce().productName();
        String description = faker.lorem().paragraph();
        page.setTitle(title);
        page.setDescription(description);
        page.setSlug(faker.app().name());
    }

    private void save(JpaRepository repository, BaseModel item) {
        try {
            repository.save(item);
        } catch (Exception e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }
    }

}
