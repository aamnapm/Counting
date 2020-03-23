package com.aamnapm.counting.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "base_entity")
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "ID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", unique = true)
    protected UUID id;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_TIME")
    private Date createdTime;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

}
