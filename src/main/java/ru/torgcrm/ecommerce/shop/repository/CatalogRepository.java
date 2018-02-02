package ru.torgcrm.ecommerce.shop.repository;

import com.sun.org.apache.xml.internal.resolver.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {
}
