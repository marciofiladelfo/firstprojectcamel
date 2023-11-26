package com.techbuzz.camel.firstcamelproject.routes.consumer;

import com.techbuzz.camel.firstcamelproject.processor.ProducerRickAndMortyProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestConsumerRouter extends RouteBuilder {

    @Autowired
    private ProducerRickAndMortyProcessor producerRickAndMortyProcessor;
    @Override
    public void configure() throws Exception {
        from("direct://consumer-rest-api")
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))

                .toD("https://rickandmortyapi.com/api/character/${header.id}?bridgeEndpoint=true")
                .process(producerRickAndMortyProcessor)
//                .unmarshal().json(JsonLibrary.Jackson, RickAndMortyResponseDto.class)
                .to("activemq:test-mq");

        from("activemq:test-mq")
            .log("log:receving messages => ${body}");
    }
}
