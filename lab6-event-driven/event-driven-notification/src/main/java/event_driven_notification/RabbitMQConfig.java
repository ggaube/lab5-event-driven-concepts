package event_driven_notification;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String NOTIFICATION_QUEUE = "notificationQueue";
    public static final String EXCHANGE = "notificationExchange";

    // Creates a new queue with the name notificationQueue and
    // sets it to be non-durable (messages will not be persisted if RabbitMQ is restarted).
    @Bean
    public Queue notificationQueue() {
        return new Queue(NOTIFICATION_QUEUE, false);
    }

    //  Creates a new topic exchange with the name notificationExchange.
    //  Topic exchanges route messages to queues based on a pattern in the routing key
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue notificationQueue, TopicExchange exchange) {
        return BindingBuilder.bind(notificationQueue).to(exchange).with(NOTIFICATION_QUEUE);
    }
}

