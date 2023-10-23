package com.pizzeria.MammaMia.Service;

import com.pizzeria.MammaMia.Dto.OrderDTO;
import com.pizzeria.MammaMia.Entity.Client;
import com.pizzeria.MammaMia.Entity.DeliveryPeople;
import com.pizzeria.MammaMia.Entity.Employ;
import com.pizzeria.MammaMia.Entity.Order;
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
        order.setMustDeliver(orderDTO.isMustDeliver());
        order.setOrderTime(orderDTO.getOrderTime());
        order.setDeliveryTime(orderDTO.getDeliveryTime());
        order.setPriceTotal(orderDTO.getPriceTotal());

        if (orderDTO.getDeliveryPeople() != null) {
            DeliveryPeople deliveryPeople = deliveryPeopleRepository.findById(Long.valueOf(orderDTO.getDeliveryPeople().getId()))
                    .orElseThrow(() -> new EntityNotFoundException("DeliveryPeople não encontrado"));
            order.setDeliveryPeople(deliveryPeople);
        }
        if (orderDTO.getClient() != null) {
            Client client = clientRepository.findById(Long.valueOf(orderDTO.getClient().getId()))
                    .orElseThrow(() -> new EntityNotFoundException("Client não encontrado"));
            order.setClient(client);
        }
        if (orderDTO.getEmploy() != null) {
            Employ employ = employRepository.findById(Long.valueOf(orderDTO.getEmploy().getId()))
                    .orElseThrow(() -> new EntityNotFoundException("Employ não encontrado"));
            order.setEmploy(employ);
        }
        return orderRepository.save(order);
    }
    public Order updateOrderFromDTO(OrderDTO orderDTO) {
        Optional<Order> existingOrder = orderRepository.findById(Long.valueOf(orderDTO.getId()));

        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();

            // Atualizar campos simples
            order.setPayment(orderDTO.getPayment());
            order.setOrderSize(orderDTO.getOrderSize());
            order.setOrderState(orderDTO.getOrderState());
            order.setMustDeliver(orderDTO.isMustDeliver());
            order.setOrderTime(orderDTO.getOrderTime());
            order.setDeliveryTime(orderDTO.getDeliveryTime());
            order.setPriceTotal(orderDTO.getPriceTotal());

            // Verificar e atualizar DeliveryPeople
            if (orderDTO.getDeliveryPeople() != null) {
                DeliveryPeople deliveryPeople = deliveryPeopleRepository.findById(Long.valueOf(orderDTO.getDeliveryPeople().getId()))
                        .orElseThrow(() -> new EntityNotFoundException("DeliveryPeople com o ID " + orderDTO.getDeliveryPeople().getId() + " não encontrado"));
                order.setDeliveryPeople(deliveryPeople);
            } else {
                throw new EntityNotFoundException("O ID de DeliveryPeople não foi fornecido");
            }

            // Verificar e atualizar Client
            if (orderDTO.getClient() != null) {
                Client client = clientRepository.findById(Long.valueOf(orderDTO.getClient().getId()))
                        .orElseThrow(() -> new EntityNotFoundException("Client com o ID " + orderDTO.getClient().getId() + " não encontrado"));
                order.setClient(client);
            } else {
                throw new EntityNotFoundException("O ID do Client não foi fornecido");
            }

            // Verificar e atualizar Employ
            if (orderDTO.getEmploy() != null) {
                Employ employ = employRepository.findById(Long.valueOf(orderDTO.getEmploy().getId()))
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

    public boolean deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Order mapDtoToOrder(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setPayment(dto.getPayment());
        order.setOrderSize(dto.getOrderSize());
        order.setOrderState(dto.getOrderState());
        order.setMustDeliver(dto.isMustDeliver());
        order.setOrderTime(dto.getOrderTime());
        order.setDeliveryTime(dto.getDeliveryTime());
        order.setPriceTotal(dto.getPriceTotal());
        return order;
    }


}

