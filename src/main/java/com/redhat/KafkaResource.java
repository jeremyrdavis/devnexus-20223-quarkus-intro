package com.redhat;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class KafkaResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaResource.class);

    @Inject
    GreetingRepository greetingRepository;

    @Incoming("greetings")
    @Transactional
    public void onGreeting(String text) {

        Greeting greeting = new Greeting();
        greeting.setText(text);
        greetingRepository.persist(greeting);
    }

}
