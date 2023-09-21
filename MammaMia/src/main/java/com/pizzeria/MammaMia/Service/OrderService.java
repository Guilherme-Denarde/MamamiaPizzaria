package com.pizzeria.MammaMia.Service;

import com.pizzeria.MammaMia.Dto.DeliveryPeopleDTO;
import com.pizzeria.MammaMia.Dto.EmployDTO;
import com.pizzeria.MammaMia.Dto.OrderDTO;
import com.pizzeria.MammaMia.Entity.Client;
import com.pizzeria.MammaMia.Entity.DeliveryPeople;
import com.pizzeria.MammaMia.Entity.Employ;
import com.pizzeria.MammaMia.Entity.Order;
import com.pizzeria.MammaMia.Exceptions.ErrorResponse;
import com.pizzeria.MammaMia.Repository.ClientRepository;
import com.pizzeria.MammaMia.Repository.DeliveryPeopleRepository;
import com.pizzeria.MammaMia.Repository.EmployRepository;
import com.pizzeria.MammaMia.Repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DeliveryPeopleRepository deliveryPeopleRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EmployRepository employRepository;


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrderFromDTO(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setPayment(orderDTO.getPayment());
        order.setOrderSize(orderDTO.getOrderSize());
        order.setOrderState(orderDTO.getOrderState());
        order.setMust_delivery(orderDTO.isMustDelivery());
        order.setOrder_time(orderDTO.getOrderTime());
        order.setDelivery_time(orderDTO.getDeliveryTime());
        order.setPriceTotal(orderDTO.getPriceTotal());

        if (orderDTO.getDeliveryPeople() != null) {
            DeliveryPeople deliveryPeople = deliveryPeopleRepository.findById(orderDTO.getDeliveryPeople().getId())
                    .orElseThrow(() -> new EntityNotFoundException("DeliveryPeople não encontrado"));
            order.setDeliveryPeopleId(deliveryPeople);
        }
        if (orderDTO.getClient() != null) {
            Client client = clientRepository.findById(orderDTO.getClient().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Client não encontrado"));
            order.setClient(client);
        }
        if (orderDTO.getEmploy() != null) {
            Employ employ = employRepository.findById(orderDTO.getEmploy().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Employ não encontrado"));
            order.setEmploy(employ);
        }
        return orderRepository.save(order);
    }
    public Order updateOrderFromDTO(OrderDTO orderDTO) {
        Optional<Order> existingOrder = orderRepository.findById(orderDTO.getId());

        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();

            // Atualizar campos simples
            order.setPayment(orderDTO.getPayment());
            order.setOrderSize(orderDTO.getOrderSize());
            order.setOrderState(orderDTO.getOrderState());
            order.setMust_delivery(orderDTO.isMustDelivery());
            order.setOrder_time(orderDTO.getOrderTime());
            order.setDelivery_time(orderDTO.getDeliveryTime());
            order.setPriceTotal(orderDTO.getPriceTotal());

            // Verificar e atualizar DeliveryPeople
            if (orderDTO.getDeliveryPeople() != null) {
                DeliveryPeople deliveryPeople = deliveryPeopleRepository.findById(orderDTO.getDeliveryPeople().getId())
                        .orElseThrow(() -> new EntityNotFoundException("DeliveryPeople com o ID " + orderDTO.getDeliveryPeople().getId() + " não encontrado"));
                order.setDeliveryPeopleId(deliveryPeople);
            } else {
                throw new EntityNotFoundException("O ID de DeliveryPeople não foi fornecido");
            }

            // Verificar e atualizar Client
            if (orderDTO.getClient() != null) {
                Client client = clientRepository.findById(orderDTO.getClient().getId())
                        .orElseThrow(() -> new EntityNotFoundException("Client com o ID " + orderDTO.getClient().getId() + " não encontrado"));
                order.setClient(client);
            } else {
                throw new EntityNotFoundException("O ID do Client não foi fornecido");
            }

            // Verificar e atualizar Employ
            if (orderDTO.getEmploy() != null) {
                Employ employ = employRepository.findById(orderDTO.getEmploy().getId())
                        .orElseThrow(() -> new EntityNotFoundException("Employ com o ID " + orderDTO.getEmploy().getId() + " não encontrado"));
                order.setEmploy(employ);
            } else {
                throw new EntityNotFoundException("O ID do Employ não foi fornecido");
            }

            // Salvar e retornar a ordem atualizada
            return orderRepository.save(order);
        } else {
            throw new EntityNotFoundException("Order com o ID " + orderDTO.getId() + " não encontrado");
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

