package com.techbuzz.camel.firstcamelproject.routes.consumer;

import com.techbuzz.camel.firstcamelproject.processor.ProducerAdviceSlipProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestConsumerRouter extends RouteBuilder {

    @Autowired
    private ProducerAdviceSlipProcessor producerAdviceSlipProcessor;
    @Override
    public void configure() throws Exception {
        from("direct://consumer-rest-api")
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .toD("https://api.adviceslip.com/advice?bridgeEndpoint=true")
                .process(producerAdviceSlipProcessor)
                .to("activemq:test-mq");

        from("activemq:test-mq")
            .log("log:receving messages => ${body}");
    }
}
