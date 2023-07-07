package app.repository;

import app.entity.Order;

import java.util.List;

public interface OrderRepository {
    Order getById(Long id);
    List<Order> getAllOrders();
    void addOrder(Order order);
    void delete(Long id);
}
