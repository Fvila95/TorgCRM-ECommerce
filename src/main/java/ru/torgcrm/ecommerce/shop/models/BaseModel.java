package ru.torgcrm.ecommerce.shop.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Base Model with required fields
 */
@MappedSuperclass
public abstract class BaseModel implements Serializable {
    @Getter
    @Setter
    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private Date createDate;

    @Getter
    @Setter
    @UpdateTimestamp
    @Column(name = "last_update_date")
    private Date lastUpdateDate;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public abstract Long getId();
}
