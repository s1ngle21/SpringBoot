package app.service;

import app.entity.Order;

import java.util.List;

public interface OderService {
    Order getById(Long id);
    List<Order> getAllOrders();
    void addOrder(Order order);

}
