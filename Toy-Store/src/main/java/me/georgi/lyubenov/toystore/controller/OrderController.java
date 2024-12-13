package me.georgi.lyubenov.toystore.controller;

import me.georgi.lyubenov.toystore.dto.OrderDTO;
import me.georgi.lyubenov.toystore.model.Order;
import me.georgi.lyubenov.toystore.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping()
    public List<OrderDTO> getOrders() {
        return orderService.findAllOrders();
    }
    @PostMapping()
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.addOrder(orderDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrderById(id);
    }
    @PatchMapping("/{id}")
    public OrderDTO updateOrder(@PathVariable int id, @RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(id, orderDTO);
    }
}
