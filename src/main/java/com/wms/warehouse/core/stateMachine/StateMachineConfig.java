package com.wms.warehouse.core.stateMachine;

import java.util.EnumSet;

import com.wms.warehouse.domain.model.Events;
import com.wms.warehouse.domain.model.States;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;


//@Configuration
//@EnableStateMachine
public class StateMachineConfig
        extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception {
        config
            .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
            .withStates()
                .initial(States.PENDENTE)
                .end(States.FINALIZADA)
                    .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
            .withExternal()
                .source(States.PENDENTE).target(States.EXECUCAO).event(Events.EXECUTAR).guard(guard1())
                .and()
            .withExternal()
                .source(States.EXECUCAO).target(States.FINALIZADA).event(Events.CONCLUIR);
    }

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>() {
            @Override
            public void stateChanged(State<States, Events> from, State<States, Events> to) {
                if(from != null){
                    System.out.println("State change from " + from.getId());
                }
                System.out.println("State change to " + to.getId());
            }
        };
    }

    @Bean
	public Guard<States, Events> guard1() {
		return new Guard<States, Events>() {
			@Override
			public boolean evaluate(StateContext<States, Events> context) {
                System.out.println("Guard ++++++++++++++++++++++++++++");
				return true;
			}
		};
	}
    
    @WithStateMachine
    public class Bean5 {
        
        @OnTransition(source = "S1", target = "S2")
        public void fromS1ToS2() {
            System.out.println("fromS1ToS2");
        }

        @OnTransition(source = "SI")
        public void fromSI() {
            System.out.println("fromSI - kkkkkkkk");
        }
        
        @OnTransition
        public void anyTransition() {
            System.out.println("anyTransition");
        }
    }
}

