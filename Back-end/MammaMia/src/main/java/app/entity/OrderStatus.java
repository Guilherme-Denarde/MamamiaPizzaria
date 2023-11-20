package app.entity;

import app.enums.StatusOrder;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "order_status")
public class OrderStatus extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private StatusOrder OrderStatuses;
    @Column(name = "status_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusTime;
}
