package ru.torgcrm.ecommerce.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.torgcrm.ecommerce.shop.models.Category;

import java.io.Serializable;

@NoRepositoryBean
public interface SimplePageRepository<T, ID extends Serializable>
        extends JpaRepository<T, ID> {
    /**
     * Find page by slug
     * @param slug slug
     * @return simple page entity by slug
     */
    Category findBySlug(String slug);
}
