package ru.torgcrm.ecommerce.shop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menus")
public class Menu extends BaseModel {
    public static final String GEN_NAME = "Gen_Menu";
    public static final String SEQ_NAME = "Seq_Menu";

    @Id
    @Setter
    @SequenceGenerator(sequenceName = SEQ_NAME, name = GEN_NAME)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GEN_NAME)
    private Long id;
    @Getter
    @Setter
    private String code;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    @JsonIgnore
    @OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
    private List<MenuItem> menuItems;

    @Override
    public Long getId() {
        return this.id;
    }
}
