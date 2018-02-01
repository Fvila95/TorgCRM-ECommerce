package ru.torgcrm.ecommerce.shop.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Base Model with required fields
 */
@MappedSuperclass
public class BaseModel implements Serializable {
    @Id
    @Getter @Setter
    @SequenceGenerator(name="sq_name", sequenceName="sq_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_name")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Getter @Setter
    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private Date createDate;

    @Getter @Setter
    @UpdateTimestamp
    @Column(name = "last_update_date", updatable = false)
    private Date lastUpdateDate;
}
