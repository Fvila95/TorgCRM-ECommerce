package ru.torgcrm.ecommerce.shop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project extends BaseModel {
    public static final String GEN_NAME = "Gen_Project";
    public static final String SEQ_NAME = "Seq_Project";

    @Id
    @Setter
    @SequenceGenerator(sequenceName = SEQ_NAME, name = GEN_NAME)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GEN_NAME)
    private Long id;
    @Getter
    @Setter
    private String domain;
    @Getter
    @Setter
    private String template;
    @Getter
    @Setter
    private String name;

    @Override
    public Long getId() {
        return this.id;
    }
}
