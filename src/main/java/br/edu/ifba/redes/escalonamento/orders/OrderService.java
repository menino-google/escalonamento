package br.edu.ifba.redes.escalonamento.orders;

import br.edu.ifba.redes.escalonamento.rabbit.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {

    private final List<Order> orders = new ArrayList<>();

    private final AtomicLong sequence = new AtomicLong(1);

    private final RabbitTemplate rabbitTemplate;

    public OrderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public List<Order> findAll() {
        return orders;
    }

    public Order create(OrderRequest request) {

        Order order = new Order(
                sequence.getAndIncrement(),
                request.userId(),
                request.productId()
        );

        orders.add(order);

        OrderEvent event = new OrderEvent(
                order.id(),
                order.userId(),
                order.productId()
        );

        rabbitTemplate.convertAndSend(
                RabbitConfig.ORDERS_QUEUE,
                event
        );

        return order;
    }
}