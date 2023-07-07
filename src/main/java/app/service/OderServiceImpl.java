package app.service;

import app.entity.Order;
import app.repository.OrderRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OderServiceImpl implements OderService {
    private OrderRepositoryImpl orderRepository;

    public OderServiceImpl(OrderRepositoryImpl orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.getById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public void addOrder(Order order) {
       orderRepository.addOrder(order);
    }

}
