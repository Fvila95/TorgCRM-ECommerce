package ru.torgcrm.ecommerce.shop.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import ru.torgcrm.ecommerce.shop.models.Item;

import java.util.List;

@Repository
public interface ItemRepository extends SimplePageRepository<Item, Long> {
    /**
     * Find all items by category id
     * @param categoryId category id
     * @return list of items
     */
    @Cacheable("basicShopCache")
    List<Item> findByCategoryId(Long categoryId);
}
