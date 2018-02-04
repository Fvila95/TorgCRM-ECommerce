package ru.torgcrm.ecommerce.shop.models;

import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order extends BaseModel {
    public static final String GEN_NAME = "Gen_Order";
    public static final String SEQ_NAME = "Seq_Order";

    @Id
    @Setter
    @SequenceGenerator(sequenceName = SEQ_NAME, name = GEN_NAME)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GEN_NAME)
    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }
}
