package ua.com.kisit.courseshop2025.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.courseshop2025.entity.Orders;
import ua.com.kisit.courseshop2025.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Orders save(Orders order) {
        return orderRepository.save(order);
    }

}
