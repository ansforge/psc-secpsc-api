package fr.ans.psc.secpsc.service;

import com.google.gson.Gson;
import fr.ans.psc.model.Ps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static fr.ans.psc.rabbitmq.conf.PscRabbitMqConfiguration.EXCHANGE_MESSAGES;
import static fr.ans.psc.rabbitmq.conf.PscRabbitMqConfiguration.PS_CREATE_MESSAGES_QUEUE_ROUTING_KEY;
import static fr.ans.psc.rabbitmq.conf.PscRabbitMqConfiguration.PS_DELETE_MESSAGES_QUEUE_ROUTING_KEY;
import static fr.ans.psc.rabbitmq.conf.PscRabbitMqConfiguration.PS_UPDATE_MESSAGES_QUEUE_ROUTING_KEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MessageProducerTest {

    private RabbitTemplate rabbitTemplate;
    private MessageProducer producer;
    private Ps ps;

    @BeforeEach
    void setUp() {
        rabbitTemplate = mock(RabbitTemplate.class);
        producer = new MessageProducer(rabbitTemplate);
        ps = new Ps();
        ps.setNationalId("800000000001");
    }

    @Test
    void sendPsMessage_create_publishesOnCreateRoutingKey() {
        producer.sendPsMessage(ps, OperationType.CREATE);

        ArgumentCaptor<Object> body = ArgumentCaptor.forClass(Object.class);
        verify(rabbitTemplate).convertAndSend(eq(EXCHANGE_MESSAGES),
                eq(PS_CREATE_MESSAGES_QUEUE_ROUTING_KEY), body.capture());
        assertThat(body.getValue()).isInstanceOf(String.class);
        assertThat((String) body.getValue()).contains("800000000001");
        assertThat(new Gson().fromJson((String) body.getValue(), Ps.class).getNationalId())
                .isEqualTo("800000000001");
    }

    @Test
    void sendPsMessage_update_publishesOnUpdateRoutingKey() {
        producer.sendPsMessage(ps, OperationType.UPDATE);

        verify(rabbitTemplate).convertAndSend(eq(EXCHANGE_MESSAGES),
                eq(PS_UPDATE_MESSAGES_QUEUE_ROUTING_KEY), eq(new Gson().toJson(ps)));
    }

    @Test
    void sendPsMessage_delete_publishesOnDeleteRoutingKey() {
        producer.sendPsMessage(ps, OperationType.DELETE);

        verify(rabbitTemplate).convertAndSend(eq(EXCHANGE_MESSAGES),
                eq(PS_DELETE_MESSAGES_QUEUE_ROUTING_KEY), eq(new Gson().toJson(ps)));
    }

    @Test
    void sendPsMessage_swallowsAmqpException() {
        doThrow(new AmqpException("broker down")).when(rabbitTemplate)
                .convertAndSend(eq(EXCHANGE_MESSAGES), eq(PS_CREATE_MESSAGES_QUEUE_ROUTING_KEY), eq(new Gson().toJson(ps)));

        assertThatNoException().isThrownBy(() -> producer.sendPsMessage(ps, OperationType.CREATE));
    }
}
