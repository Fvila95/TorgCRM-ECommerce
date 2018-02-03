package ru.torgcrm.ecommerce.shop.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.torgcrm.ecommerce.shop.models.Category;
import ru.torgcrm.ecommerce.shop.models.SimplePage;

import java.io.Serializable;

@NoRepositoryBean
public interface SimplePageRepository<T, ID extends Serializable>
        extends JpaRepository<T, ID> {
    /**
     * Find page by slug
     * @param slug slug
     * @return simple page entity by slug
     */
    @Cacheable("basicShopCache")
    SimplePage findBySlug(String slug);
}
