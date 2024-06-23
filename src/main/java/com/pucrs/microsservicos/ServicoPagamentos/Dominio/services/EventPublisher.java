package com.pucrs.microsservicos.ServicoPagamentos.Dominio.services;

import com.pucrs.microsservicos.ServicoPagamentos.Dominio.events.PagServCadEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.pucrs.microsservicos.RabbitMQConfig.FANOUTEXCHANGENAME;

@Component
public class EventPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishPagServCadEvent(PagServCadEvent event) {
        rabbitTemplate.convertAndSend(FANOUTEXCHANGENAME, "", event);
    }
}
