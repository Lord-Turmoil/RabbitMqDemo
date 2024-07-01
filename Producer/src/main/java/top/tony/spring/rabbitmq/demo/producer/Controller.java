package top.tony.spring.rabbitmq.demo.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {
    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/send")
    public Message send(@RequestBody String text) {
        Message message = new Message();
        message.setTimestamp(LocalDateTime.now());
        message.setMessage(text);
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTING_KEY, message);
        return message;
    }
}
