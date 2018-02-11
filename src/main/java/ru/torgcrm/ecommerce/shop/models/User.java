package ru.torgcrm.ecommerce.shop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseModel {
    public static final String GEN_NAME = "Gen_User";
    public static final String SEQ_NAME = "Seq_User";

    @Id
    @Setter
    @SequenceGenerator(sequenceName = SEQ_NAME, name = GEN_NAME)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GEN_NAME)
    private Long id;

    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    private String password;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    @BatchSize(size = 20)
    @Getter
    @Setter
    private Set<Authority> authorities = new HashSet<>();

    @Override
    public Long getId() {
        return this.id;
    }
}
