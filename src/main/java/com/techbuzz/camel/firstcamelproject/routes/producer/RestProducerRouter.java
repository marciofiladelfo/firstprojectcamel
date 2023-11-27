package com.techbuzz.camel.firstcamelproject.routes.producer;

import com.techbuzz.camel.firstcamelproject.model.AdviceSlipResponseDto;
import com.techbuzz.camel.firstcamelproject.model.SlipResponseDto;
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

        rest("/api/adviceslip")
            .get()
                .skipBindingOnErrorCode(true)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .to("direct://consumer-rest-api");
    }
}
