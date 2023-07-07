package app.controller;

import app.entity.Order;
import app.service.OderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/orders")
public class OrderController {
    private OderServiceImpl orderService;

    public OrderController(final OderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getOrderById(@PathVariable(name = "id") Long id) {
        Order order = orderService.getById(id);
        return ResponseEntity
                .ok()
                .body(order);
    }

    @GetMapping
    ResponseEntity<?> getALlOrders() {
        return ResponseEntity
                .ok()
                .body(orderService.getAllOrders());
    }

    @PostMapping
    @ResponseBody
    ResponseEntity<?> addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return ResponseEntity
                .ok().build();
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteOrder(@PathVariable(name = "id") Long id) {
        orderService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }




}
