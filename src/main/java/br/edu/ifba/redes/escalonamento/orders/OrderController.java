package br.edu.ifba.redes.escalonamento.orders;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Order> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Order create(@RequestBody OrderRequest request) {
        return service.create(request);
    }
}