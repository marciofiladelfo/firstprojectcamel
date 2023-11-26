package com.techbuzz.camel.firstcamelproject.routes.producer;

import com.techbuzz.camel.firstcamelproject.model.RickAndMortyResponseDto;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class RestProducerRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration()
            .component("servlet")
            .bindingMode(RestBindingMode.auto);

        rest("/api/rickandmorty")
            .get()
                .skipBindingOnErrorCode(true)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .outType(RickAndMortyResponseDto.class)
            .to("direct://producer-rest-api");


        from("direct://producer-rest-api")
            .to("direct://consumer-rest-api");
    }
}
