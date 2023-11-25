package com.techbuzz.camel.firstcamelproject.routes.filamq;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMqReceiverRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:test-mq")
                .log("log:receving messages => ${body}");
    }
}
