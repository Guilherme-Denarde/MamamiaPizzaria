package com.pizzeria.MammaMia.Controller;

import com.pizzeria.MammaMia.Dto.OrderDTO;
import com.pizzeria.MammaMia.Entity.Order;
import com.pizzeria.MammaMia.Service.OrderService;
import com.pizzeria.MammaMia.Mapper.OrderMapper;
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

        Order order = orderService.createOrder(orderDto);
        return ResponseEntity.ok(order.toDTO());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteOrder(@RequestParam("id") Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

        Order Order = orderMapper.orderDTOToOrder(orderDto);
        Order createdOrder = orderService.createOrder(Order);
        return ResponseEntity.ok(orderMapper.orderToOrderDTO(createdOrder));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDto) {
        if (!id.equals(orderDto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Order Order = orderMapper.orderDTOToOrder(orderDto);
        Order updatedOrder = orderService.updateOrder(Order);
        return ResponseEntity.ok(orderMapper.orderToOrderDTO(updatedOrder));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
