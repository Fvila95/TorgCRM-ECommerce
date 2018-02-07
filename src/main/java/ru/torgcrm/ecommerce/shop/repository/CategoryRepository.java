package ru.torgcrm.ecommerce.shop.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.torgcrm.ecommerce.shop.config.BasicShopCacheConfiguration;
import ru.torgcrm.ecommerce.shop.models.Category;
import ru.torgcrm.ecommerce.shop.models.SimplePage;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    List<Category> findAll();

    /**
     * Find page by slug
     *
     * @param slug slug
     * @return simple page entity by slug
     */
    @Cacheable(BasicShopCacheConfiguration.CACHE_CATEGORY_BY_SLUG)
    SimplePage findBySlug(String slug);
}
