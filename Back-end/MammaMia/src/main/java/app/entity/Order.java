package app.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "order")
public class Order extends AbstractEntity{
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @Column(name = "total_price")
    private Float totalPrice;
    @Column(name = "requires_delivery")
    private boolean requiresDelivery;
    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private Address deliveryAddress;
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_time")
    private Date orderTime;
    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;
    @OneToMany(mappedBy = "order")
    private Set<OrderStatus> orderStatus;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
}
