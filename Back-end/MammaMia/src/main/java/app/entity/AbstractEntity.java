package app.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Data
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

    private Boolean status;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        status = true;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

}
