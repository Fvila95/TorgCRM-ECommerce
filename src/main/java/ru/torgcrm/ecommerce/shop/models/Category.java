package ru.torgcrm.ecommerce.shop.models;

import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends SimplePage {
    public static final String GEN_NAME  = "Gen_Category";
    public static final String SEQ_NAME  = "Seq_Category";

    @Id @Setter
    @SequenceGenerator(sequenceName = SEQ_NAME, name = GEN_NAME)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GEN_NAME)
    private Long id;

    public Long getId() {
        return id;
    }
}
