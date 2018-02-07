package ru.torgcrm.ecommerce.shop.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.torgcrm.ecommerce.shop.config.BasicShopCacheConfiguration;
import ru.torgcrm.ecommerce.shop.models.Item;
import ru.torgcrm.ecommerce.shop.models.SimplePage;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    /**
     * Find all items by category id
     *
     * @param categoryId category id
     * @return list of items
     */
    List<Item> findByCategoryId(Long categoryId);

    /**
     * Find page by slug
     *
     * @param slug slug
     * @return simple page entity by slug
     */
    @Cacheable(BasicShopCacheConfiguration.CACHE_ITEMS_BY_SLUG)
    SimplePage findBySlug(String slug);
}
