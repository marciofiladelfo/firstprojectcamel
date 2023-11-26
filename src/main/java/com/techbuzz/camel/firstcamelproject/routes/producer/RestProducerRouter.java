package com.techbuzz.camel.firstcamelproject.routes.producer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class RestProducerRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration()
            .component("servlet");

        rest("/techbuzz")
            .get()
            .to("direct:tech-buzz-blogs");

        from("direct:tech-buzz-blogs")
            .transform().constant("Welcome to Tech Buzz Blogs !!");
    }
}
