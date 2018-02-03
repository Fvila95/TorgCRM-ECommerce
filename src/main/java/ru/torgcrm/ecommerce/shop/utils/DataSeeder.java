package ru.torgcrm.ecommerce.shop.utils;

import com.github.javafaker.Faker;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.torgcrm.ecommerce.shop.models.*;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataSeeder {

    /**
     * Populate items table
     * @param quantity total quantity of generated items
     * @param repository item repository
     */
    public void seedItems(int quantity, JpaRepository repository) {
        List<Item> items = Stream.generate(Item::new)
                .limit(quantity)
                .collect(Collectors.toList());
        items.forEach((Item item) -> {
            Faker faker = new Faker(new Locale("ru"));
            seedSimplePageData(item);
            item.setPrice(new Double(faker.commerce().price()));
            save(repository, item);
        });
    }

    /**
     * Populate category
     * @param quantity quantity of generated categories
     * @param repository jpa repository
     */
    public void seedCategory(int quantity, JpaRepository repository) {
        List<Category> categories = Stream.generate(Category::new)
                .limit(quantity)
                .collect(Collectors.toList());
        categories.forEach(category -> {
            seedSimplePageData(category);
            save(repository, category);
        });
    }

    /**
     * Populate menu
     * @param quantity quantity of generated menus
     * @param repository jpa repository
     */
    public void seedMenu(int quantity, JpaRepository repository) {
        List<Menu> menus = Stream.generate(Menu::new)
                .limit(quantity)
                .collect(Collectors.toList());
        menus.forEach(menu -> save(repository, menu));
    }

    /**
     * Populate menu item
     * @param quantity quantity of generated menu items
     * @param repository jpa repository
     */
    public void seedMenuItem(int quantity, JpaRepository repository) {
        List<MenuItem> menus = Stream.generate(MenuItem::new)
                .limit(quantity)
                .collect(Collectors.toList());
        menus.forEach(menuItem -> save(repository, menuItem));
    }

    /**
     * Populate menu item
     * @param quantity quantity of generated menu items
     * @param repository jpa repository
     */
    public void seedNews(int quantity, JpaRepository repository) {
        List<News> news = Stream.generate(News::new)
                .limit(quantity)
                .collect(Collectors.toList());
        news.forEach(n -> {
            seedSimplePageData(n);
            save(repository, n);
        });
    }

    /**
     * Populate menu item
     * @param quantity quantity of generated menu items
     * @param repository jpa repository
     */
    public void seedOrders(int quantity, JpaRepository repository) {
        List<Order> orders = Stream.generate(Order::new)
                .limit(quantity)
                .collect(Collectors.toList());
        orders.forEach(order -> save(repository, order));
    }

    /**
     * Populate menu item
     * @param quantity quantity of generated menu items
     * @param repository jpa repository
     */
    public void seedResponses(int quantity, JpaRepository repository) {
        List<Response> responses = Stream.generate(Response::new)
                .limit(quantity)
                .collect(Collectors.toList());
        responses.forEach(response -> save(repository, response));
    }

    /**
     * Generate basic simple page fake data
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
