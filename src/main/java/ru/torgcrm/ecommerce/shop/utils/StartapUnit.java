package ru.torgcrm.ecommerce.shop.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.torgcrm.ecommerce.shop.repository.CategoryRepository;

import javax.annotation.PostConstruct;

@Component
public class StartapUnit {

    @Value("${shop.generated_test_data}")
    private boolean generateTestData;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private DataSeeder seeder;

    @PostConstruct
    public void init() {
        seeder.seedAuthority();
        seeder.seedUser();
        if (generateTestData) {
            seeder.seedProjects();
            seeder.seedResponses(10);
            seeder.seedMenu();
            seeder.seedMenuItem(5);
            seeder.seedCategory(5);
            seeder.seedItemsWithCategories(50, categoryRepository.findAll());
        }
    }
}
