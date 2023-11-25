package com.techbuzz.camel.firstcamelproject.routes.filamq;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMqSenderRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer://test?period=10000")
                .setBody(simple("Bem vindo a fila MQ"))
                .to("activemq:test-mq");
    }
}
