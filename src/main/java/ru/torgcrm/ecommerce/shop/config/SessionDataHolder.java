package ru.torgcrm.ecommerce.shop.config;

import ru.torgcrm.ecommerce.shop.dto.CartObjectDTO;

import java.util.ArrayList;
import java.util.List;

public class SessionDataHolder {
    /**
     * Hold product id and quantity
     */
    private List<CartObjectDTO> cartObjects;

    public List<CartObjectDTO> getCartObjects() {
        if (cartObjects == null) {
            cartObjects = new ArrayList<>();
        }
        return cartObjects;
    }
}
