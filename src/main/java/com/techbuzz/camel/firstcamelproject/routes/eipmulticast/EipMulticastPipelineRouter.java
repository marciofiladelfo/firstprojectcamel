package com.techbuzz.camel.firstcamelproject.routes.eipmulticast;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EipMulticastPipelineRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet");

        rest("/payment")
            .get()
            .to("direct:payment-completed");

        from("direct:payment-completed")
            .setBody().constant("Payment Completed for your Online Purchase. Thanks!!")
            .multicast()
            .to("direct:sender-bank-system")
            .to("direct:receive-bank-system")
            .to("direct:online-shopping-system");

        from("direct:sender-bank-system")
            .setBody().constant("Sender is recived payment.")
            .log("${body}");

        from("direct:receive-bank-system")
            .setBody().constant("Receive the payment.")
            .log("${body}");

        from("direct:online-shopping-system")
            .log("${body}");
    }
}
