package ru.torgcrm.ecommerce.shop.models;

import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item extends SimplePage {
    public static final String GEN_NAME  = "Gen_Item";
    public static final String SEQ_NAME  = "Seq_Item";

    @Id @Setter
    @SequenceGenerator(sequenceName = SEQ_NAME, name = GEN_NAME)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GEN_NAME)
    private Long id;

    public Long getId() {
        return id;
    }
}
