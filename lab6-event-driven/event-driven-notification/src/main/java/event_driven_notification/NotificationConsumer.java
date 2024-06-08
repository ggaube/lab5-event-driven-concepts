package event_driven_notification;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @RabbitListener(queues = RabbitMQConfig.NOTIFICATION_QUEUE)
    public void receiveNotification(String message) {
        System.out.println("Received notification: " + message);
    }
}
