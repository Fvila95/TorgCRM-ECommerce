package ru.torgcrm.ecommerce.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.torgcrm.ecommerce.shop.models.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
}
