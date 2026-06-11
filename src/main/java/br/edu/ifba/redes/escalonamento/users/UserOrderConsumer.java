package br.edu.ifba.redes.escalonamento.users;

import br.edu.ifba.redes.escalonamento.orders.OrderEvent;
import br.edu.ifba.redes.escalonamento.rabbit.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserOrderConsumer {

    @RabbitListener(queues = RabbitConfig.ORDERS_QUEUE)
    public void consume(OrderEvent event) {

        System.out.println(
                "[USERS] Pedido recebido: "
                        + event.orderId()
        );
    }
}