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

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/findAll")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<Order> Order = orderService.getAllOrders();
        return ResponseEntity.ok(Order.stream().map(orderMapper::orderToOrderDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(orderMapper::orderToOrderDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDto) {
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
