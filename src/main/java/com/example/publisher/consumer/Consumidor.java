package com.example.publisher.consumer;

import com.example.publisher.config.config;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
public class Consumidor {

    @RabbitListener(queues = config.QUEUE)
    public void consumeMessaggeFromQueue(String mensaje){
        System.out.println("Mensaje: " + mensaje);
    }

}
