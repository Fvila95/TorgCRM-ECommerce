package ru.torgcrm.ecommerce.shop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends SimplePage {
    public static final String GEN_NAME = "Gen_Category";
    public static final String SEQ_NAME = "Seq_Category";

    @Id
    @Setter
    @SequenceGenerator(sequenceName = SEQ_NAME, name = GEN_NAME)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GEN_NAME)
    private Long id;

    @Getter
    @Setter
    @OneToMany(mappedBy = "category")
    private List<Item> items;

    public Long getId() {
        return id;
    }

    public String getPermanentUrl() {
        return "/category/" + getSlug();
    }
}
