package ru.torgcrm.ecommerce.shop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "authority")
public class Authority extends BaseModel {
    public static final String GEN_NAME = "Gen_Authority";
    public static final String SEQ_NAME = "Seq_Authority";

    @Id
    @Setter
    @SequenceGenerator(sequenceName = SEQ_NAME, name = GEN_NAME)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GEN_NAME)
    private Long id;

    @Getter
    @Setter
    private String name;

    @Override
    public Long getId() {
        return this.id;
    }
}
