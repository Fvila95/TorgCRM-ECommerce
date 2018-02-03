package ru.torgcrm.ecommerce.shop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item extends SimplePage {
    public static final String GEN_NAME  = "Gen_Item";
    public static final String SEQ_NAME  = "Seq_Item";

    @Id @Setter
    @SequenceGenerator(sequenceName = SEQ_NAME, name = GEN_NAME)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GEN_NAME)
    private Long id;

    @Getter @Setter
    private Double price;

    @Getter @Setter
    @ManyToOne @JoinColumn(name = "category_id")
    private Category category;

    public Long getId() {
        return id;
    }
}
