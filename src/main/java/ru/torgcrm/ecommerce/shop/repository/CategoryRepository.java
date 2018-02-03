package ru.torgcrm.ecommerce.shop.repository;

import org.springframework.stereotype.Repository;
import ru.torgcrm.ecommerce.shop.models.Category;

@Repository
public interface CategoryRepository extends SimplePageRepository<Category, Long> {
}
