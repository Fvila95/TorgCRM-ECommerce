package ru.torgcrm.ecommerce.shop.models;

import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "menu_items")
public class MenuItem extends BaseModel {
    public static final String GEN_NAME  = "Gen_MenuItem";
    public static final String SEQ_NAME  = "Seq_MenuItem";

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
