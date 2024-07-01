package top.tony.spring.rabbitmq.demo.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMqConfig {
    public static final String EXCHANGE = "e.demo.exchange";
    public static final String ROUTING_KEY = "key";
    public static final String QUEUE = "q.demo.queue";

    private final CachingConnectionFactory connectionFactory;

    @Bean
    public Binding getBinding() {
        return BindingBuilder.bind(getQueue()).to(getExchange()).with(ROUTING_KEY);
    }

    @Bean
    public Queue getQueue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public DirectExchange getExchange() {
        return new DirectExchange(EXCHANGE, true, false);
    }

    @Bean
    public RabbitTemplate getRabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(getConverter());
        return template;
    }

    @Bean
    public Jackson2JsonMessageConverter getConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
