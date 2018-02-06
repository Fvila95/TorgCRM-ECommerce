package ru.torgcrm.ecommerce.shop.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.torgcrm.ecommerce.shop.config.SessionDataHolder;
import ru.torgcrm.ecommerce.shop.dto.CartObjectDTO;

import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/cart")
public class RestCartController {

    @Autowired
    SessionDataHolder sessionDataHolder;

    @ResponseBody
    @PostMapping(consumes = MediaType.APPLICATION_JSON)
    public String add(@RequestBody CartObjectDTO cartObjectDTO) {
        System.out.println(sessionDataHolder.getCartObjects().size());
        OptionalInt indexOpt = IntStream.range(0, sessionDataHolder.getCartObjects().size())
                .filter(i -> cartObjectDTO.equals(sessionDataHolder.getCartObjects().get(i)))
                .findFirst();
        CartObjectDTO cartObjectInSession = sessionDataHolder.getCartObjects().get(indexOpt.getAsInt());
        if (cartObjectInSession != null) {
            Integer quantity = cartObjectInSession.getQuantity();
            sessionDataHolder.getCartObjects().get(indexOpt.getAsInt())
                    .setQuantity(quantity <= 0 ? 1 : quantity + 1);
        } else {
            sessionDataHolder.getCartObjects().add(cartObjectDTO);
        }

        return "OK";
    }

    @ResponseBody
    @GetMapping("/quantity")
    public Integer quantity() {
        Integer quantity = 0;
        for (CartObjectDTO obj : sessionDataHolder.getCartObjects()) {
            quantity += obj.getQuantity();
        }
        return quantity;
    }

    @ResponseBody
    @GetMapping
    public List<CartObjectDTO> get() {
        return sessionDataHolder.getCartObjects();
    }
}
