package app.service;

import app.entity.Order;
import app.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OderServiceImpl implements OderService {
    private OrderRepository orderRepository;

    public OderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Order getById(Long id) {
        return orderRepository.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public void addOrder(Order order) {
       orderRepository.addOrder(order);
    }

}
