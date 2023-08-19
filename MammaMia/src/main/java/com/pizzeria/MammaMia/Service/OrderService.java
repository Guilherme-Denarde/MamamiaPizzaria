package com.pizzeria.MammaMia.Service;

import com.pizzeria.MammaMia.Entity.Order;
import com.pizzeria.MammaMia.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order Order) {
        return orderRepository.save(Order);
    }

    public Order updateOrder(Order Order) {
        return orderRepository.save(Order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
