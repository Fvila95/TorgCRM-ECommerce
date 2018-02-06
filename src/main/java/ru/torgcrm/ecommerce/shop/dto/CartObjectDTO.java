package ru.torgcrm.ecommerce.shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import java.util.Objects;

public class CartObjectDTO {
    @Getter @Setter
    @JsonProperty("product_id")
    private Long productId;
    @Getter @Setter
    @JsonProperty("quantity")
    private Integer quantity = 0;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof CartObjectDTO)) return false;
        CartObjectDTO cartObj = (CartObjectDTO) obj;
        return productId == cartObj.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }
}
