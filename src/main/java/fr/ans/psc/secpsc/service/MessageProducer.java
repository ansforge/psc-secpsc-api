package fr.ans.psc.secpsc.service;

import com.google.gson.Gson;
import fr.ans.psc.model.Ps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static fr.ans.psc.rabbitmq.conf.PscRabbitMqConfiguration.EXCHANGE_MESSAGES;
import static fr.ans.psc.rabbitmq.conf.PscRabbitMqConfiguration.PS_CREATE_MESSAGES_QUEUE_ROUTING_KEY;
import static fr.ans.psc.rabbitmq.conf.PscRabbitMqConfiguration.PS_DELETE_MESSAGES_QUEUE_ROUTING_KEY;
import static fr.ans.psc.rabbitmq.conf.PscRabbitMqConfiguration.PS_UPDATE_MESSAGES_QUEUE_ROUTING_KEY;

@Slf4j
@Component
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Gson gson = new Gson();

    public MessageProducer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendPsMessage(Ps ps, OperationType operation) {
        log.debug("Sending {} message for Ps {}", operation, ps.getNationalId());

        String routingKey;
        switch (operation) {
            case CREATE:
                routingKey = PS_CREATE_MESSAGES_QUEUE_ROUTING_KEY;
                break;
            case UPDATE:
                routingKey = PS_UPDATE_MESSAGES_QUEUE_ROUTING_KEY;
                break;
            case DELETE:
                routingKey = PS_DELETE_MESSAGES_QUEUE_ROUTING_KEY;
                break;
            default:
                log.warn("Unknown OperationType {}, skipping publish", operation);
                return;
        }

        try {
            rabbitTemplate.convertAndSend(EXCHANGE_MESSAGES, routingKey, gson.toJson(ps));
        } catch (AmqpException e) {
            log.error("Failed to publish {} message for Ps {} to RabbitMQ", operation, ps.getNationalId(), e);
        }
    }
}
