package app.controller;

import app.entity.Order;
import app.service.OderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {
    private OderService orderService;

    public OrderController(final OderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    ResponseEntity<Order> getOrderById(@PathVariable(name = "id") Long id) {
        Order order = orderService.getById(id);
        return ResponseEntity
                .ok()
                .body(order);
    }

    @GetMapping
    ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity
                .ok()
                .body(orderService.getAllOrders());
    }


}
