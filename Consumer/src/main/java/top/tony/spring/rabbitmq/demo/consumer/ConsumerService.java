package top.tony.spring.rabbitmq.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {
    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void receive(Message message) {
        log.info("Received message: {}", message);
    }
}
