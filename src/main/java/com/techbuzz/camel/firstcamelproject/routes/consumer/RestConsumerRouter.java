package com.techbuzz.camel.firstcamelproject.routes.consumer;

import com.techbuzz.camel.firstcamelproject.processor.ConsumeCarProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestConsumerRouter extends RouteBuilder {

    @Autowired
    private ConsumeCarProcessor consumeCarProcessor;
    @Override
    public void configure() throws Exception {
        from("timer://test-rest-api?period=10000")
                .log("Rest API Calling...")
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .to("http://localhost:9090/api/car")
                .process(consumeCarProcessor);
    }
}
