package com.pizzeria.MammaMia.Controller;

import com.pizzeria.MammaMia.Dto.OrderDTO;
import com.pizzeria.MammaMia.Entity.Order;
import com.pizzeria.MammaMia.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/findAll")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders()
                .stream()
                .map(Order::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(orders);
    }

    @GetMapping
    public ResponseEntity<OrderDTO> getOrderById(@RequestParam("id") Long id) {
        return orderService.getOrderById(id)
                .map(Order::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDto) {
        Order orders = orderService.createOrder(orderDto);
        return ResponseEntity.ok(orders.toDTO());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteOrder(@RequestParam("id") Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}
