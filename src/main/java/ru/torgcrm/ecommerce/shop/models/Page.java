package ru.torgcrm.ecommerce.shop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pages")
public class Page extends SimplePage {
    public static final String GEN_NAME = "Gen_Page";
    public static final String SEQ_NAME = "Seq_Page";

    @Id
    @Setter
    @SequenceGenerator(sequenceName = SEQ_NAME, name = GEN_NAME)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GEN_NAME)
    private Long id;

    @Lob
    @Getter @Setter
    private String content;

    @Override
    public Long getId() {
        return this.id;
    }
}
