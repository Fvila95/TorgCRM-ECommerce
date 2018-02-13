package ru.torgcrm.ecommerce.shop.controllers.rest.admin;

import ru.torgcrm.ecommerce.shop.models.BaseModel;
import java.util.List;

public abstract class AdminRestController <T extends BaseModel> {
    public abstract List<T> list();
    public abstract T create(T model);
    public abstract T update(T model);
    public abstract T getById(Long id);
    public abstract void delete(Long id);
}
