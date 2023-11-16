package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Enums.StatusType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        if (status == null) { // Define um valor padrão para status, se necessário
            status = StatusType.ATIVO;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }


}
