package com.pizzeria.MammaMia.Service;

import com.pizzeria.MammaMia.Dto.OrderDTO;
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

    public Order createOrder(OrderDTO orderDto) {
        Order order = mapDtoToOrder(orderDto);
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, OrderDTO orderDto) {
        Optional<Order> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            Order updatedOrder = mapDtoToOrder(orderDto);
            updatedOrder.setId(id);
            return orderRepository.save(updatedOrder);
        } else {
            return null;
        }

    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order mapDtoToOrder(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setPayment(dto.getPayment());
        order.setOrderSize(dto.getOrderSize());
        order.setOrderState(dto.getOrderState());
        order.setMust_delivery(dto.isMustDelivery());
        order.setOrder_time(dto.getOrderTime());
        order.setDelivery_time(dto.getDeliveryTime());
        order.setPriceTotal(dto.getPriceTotal());
        return order;
    }


}


