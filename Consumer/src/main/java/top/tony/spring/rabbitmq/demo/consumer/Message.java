package top.tony.spring.rabbitmq.demo.consumer;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class Message {
    private LocalDateTime timestamp;
    private String message;
}
