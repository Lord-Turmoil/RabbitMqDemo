package top.tony.spring.rabbitmq.demo.producer;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {
    private LocalDateTime timestamp;
    private String message;
}
