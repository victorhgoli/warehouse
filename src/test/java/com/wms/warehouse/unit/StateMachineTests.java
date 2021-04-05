package com.wms.warehouse.unit;

import com.wms.warehouse.domain.model.Events;
import com.wms.warehouse.domain.model.States;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;

import reactor.core.publisher.Mono;

@SpringBootTest
public class StateMachineTests {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Test
    public void testmachine() {

        stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(Events.EXECUTAR).build())).subscribe();

        stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(Events.CONCLUIR).build())).subscribe();
    }

}
