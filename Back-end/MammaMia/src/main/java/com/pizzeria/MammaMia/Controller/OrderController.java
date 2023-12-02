package com.pizzeria.MammaMia.Controller;

import com.pizzeria.MammaMia.Dto.OrderDTO;
import com.pizzeria.MammaMia.Entity.Order;
import com.pizzeria.MammaMia.Exceptions.ErrorResponse;
import com.pizzeria.MammaMia.Response.ResponseWrapper;
import com.pizzeria.MammaMia.Service.OrderService;
import com.pizzeria.MammaMia.security.config.JwtService;
import com.pizzeria.MammaMia.security.user.User;
import com.pizzeria.MammaMia.security.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll")
    @PreAuthorize("hasAnyRole('MANAGER')")

    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders()
                .stream()
                .map(Order::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(orders);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")
    public ResponseEntity<ResponseWrapper<OrderDTO>> getOrderById(@RequestParam("id") Long id) {
        return orderService.getOrderById(id)
                .map(Order::toDTO)
                .map(dto -> ResponseEntity.ok(new ResponseWrapper<>(dto)))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ResponseWrapper<>("Order with ID " + id + " not found.")));
    }

    //TODO criar um endpoint que lista todas as orders daquele cliente



    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('CLIENTE')")

    public ResponseEntity<List<Order>> GetAllMe (

            HttpServletRequest request
    ) {
        final String userEmail;
        final String jwt;
        final String authHeader = request.getHeader("Authorization");
        jwt = authHeader.substring(7);
        userEmail = jwtService.extractUsername(jwt);
        Optional<User> user = userRepository.findByEmail(userEmail);

        return ResponseEntity.ok(orderService.getAllMe(user.get()));




    }


    @PostMapping
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")

    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDto) {
        Order orders = orderService.createOrderFromDTO(orderDto);
        return ResponseEntity.ok(orders.toDTO());
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")

    public ResponseEntity<Object> updateOrder(@RequestParam("id") Long id, @RequestBody OrderDTO orderDTO) {
            if (!id.equals(Long.valueOf(orderDTO.getId()))) {
                return ResponseEntity.badRequest().body(new ErrorResponse("ID na URL não corresponde ao ID no corpo da requisição", 400));
            }
            Order updatedOrder = orderService.updateOrderFromDTO(orderDTO);
            return ResponseEntity.ok(updatedOrder.toDTO());
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")

    public ResponseEntity<String> deleteOrder(@RequestParam("id") Long id) {
        boolean isDeleted = orderService.deleteOrder(id);

        if (isDeleted) {
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Order with ID " + id + " does not exist");
        }
    }
}
