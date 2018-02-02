package ru.torgcrm.ecommerce.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.torgcrm.ecommerce.shop.models.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
