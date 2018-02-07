package ru.torgcrm.ecommerce.shop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends BaseModel {
    public static final String GEN_NAME = "Gen_Customer";
    public static final String SEQ_NAME = "Seq_Customer";

    @Id
    @Setter
    @SequenceGenerator(sequenceName = SEQ_NAME, name = GEN_NAME)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GEN_NAME)
    private Long id;

    @Getter @Setter
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    List<Order> orders;

    @Override
    public Long getId() {
        return this.id;
    }
}
