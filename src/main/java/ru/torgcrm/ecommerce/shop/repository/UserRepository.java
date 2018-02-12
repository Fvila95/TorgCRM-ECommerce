package ru.torgcrm.ecommerce.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.torgcrm.ecommerce.shop.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String login);
}
