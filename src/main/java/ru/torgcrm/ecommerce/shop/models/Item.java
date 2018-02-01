package ru.torgcrm.ecommerce.shop.models;

import javax.persistence.*;

@Entity
@Table(name = "item")
@SequenceGenerator(name = "sq_name", sequenceName = "sq_item")
public class Item extends SimplePage {
}
