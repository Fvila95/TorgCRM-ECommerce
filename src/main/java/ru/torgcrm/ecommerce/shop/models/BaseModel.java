package ru.torgcrm.ecommerce.shop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.ZonedDateTime;

/**
 * Base Model with required fields
 */
@Getter
@Setter
public class BaseModel {
    @Id
    private Long id;
    private ZonedDateTime createDate;
    private ZonedDateTime lastUpdateDate;
}
