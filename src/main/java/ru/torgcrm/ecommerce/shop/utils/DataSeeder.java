package ru.torgcrm.ecommerce.shop.utils;

import com.github.javafaker.Faker;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.torgcrm.ecommerce.shop.models.*;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataSeeder {

    /**
     * Populate items table
     * @param quantity total quantity of generated items
     * @param repository item repository
     */
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

    /**
     * Populate category
     * @param quantity quantity of generated categories
     * @param repository jpa repository
     */
    public void seedCategory(int quantity, JpaRepository repository) {
        Faker faker = new Faker(new Locale("ru"));
        List<Category> categories = Stream.generate(Category::new)
                .limit(quantity)
                .collect(Collectors.toList());
        categories.forEach(category -> {
            String title = faker.commerce().department();
            String description = faker.lorem().paragraph();

            category.setTitle(title);
            category.setDescription(description);
            repository.save(category);
        });
    }

    /**
     * Populate menu
     * @param quantity quantity of generated menus
     * @param repository jpa repository
     */
    public void seedMenu(int quantity, JpaRepository repository) {
        Faker faker = new Faker(new Locale("ru"));
        List<Menu> menus = Stream.generate(Menu::new)
                .limit(quantity)
                .collect(Collectors.toList());
        menus.forEach(menu -> {
            repository.save(menu);
        });
    }

    /**
     * Populate menu item
     * @param quantity quantity of generated menu items
     * @param repository jpa repository
     */
    public void seedMenuItem(int quantity, JpaRepository repository) {
        Faker faker = new Faker(new Locale("ru"));
        List<MenuItem> menus = Stream.generate(MenuItem::new)
                .limit(quantity)
                .collect(Collectors.toList());
        menus.forEach(menuItem -> {
            repository.save(menuItem);
        });
    }

    /**
     * Populate menu item
     * @param quantity quantity of generated menu items
     * @param repository jpa repository
     */
    public void seedNews(int quantity, JpaRepository repository) {
        Faker faker = new Faker(new Locale("ru"));
        List<News> news = Stream.generate(News::new)
                .limit(quantity)
                .collect(Collectors.toList());
        news.forEach(n -> {
            n.setTitle(faker.commerce().productName());
            n.setDescription(faker.lorem().paragraph());
            repository.save(n);
        });
    }

    /**
     * Populate menu item
     * @param quantity quantity of generated menu items
     * @param repository jpa repository
     */
    public void seedOrders(int quantity, JpaRepository repository) {
        Faker faker = new Faker(new Locale("ru"));
        List<Order> orders = Stream.generate(Order::new)
                .limit(quantity)
                .collect(Collectors.toList());
        orders.forEach(order -> {
            repository.save(order);
        });
    }

    /**
     * Populate menu item
     * @param quantity quantity of generated menu items
     * @param repository jpa repository
     */
    public void seedResponses(int quantity, JpaRepository repository) {
        Faker faker = new Faker(new Locale("ru"));
        List<Response> responses = Stream.generate(Response::new)
                .limit(quantity)
                .collect(Collectors.toList());
        responses.forEach(response -> {
            repository.save(response);
        });
    }

}
