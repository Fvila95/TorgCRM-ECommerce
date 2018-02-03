package ru.torgcrm.ecommerce.shop.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import ru.torgcrm.ecommerce.shop.models.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends SimplePageRepository<Category, Long> {
    @Override
    @Cacheable("basicShopCache")
    List<Category> findAll();
}
