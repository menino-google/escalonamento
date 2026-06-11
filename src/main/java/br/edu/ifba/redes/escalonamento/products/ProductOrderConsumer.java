package br.edu.ifba.redes.escalonamento.products;

import br.edu.ifba.redes.escalonamento.orders.OrderEvent;
import br.edu.ifba.redes.escalonamento.rabbit.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductOrderConsumer {

    @RabbitListener(queues = RabbitConfig.ORDERS_QUEUE)
    public void consume(OrderEvent event) {

        System.out.println(
                "[PRODUCTS] Pedido recebido: "
                        + event.orderId()
        );
    }
}