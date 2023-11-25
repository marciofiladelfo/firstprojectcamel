package com.techbuzz.camel.firstcamelproject.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ConsumeCarProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String output = exchange.getIn().getBody(String.class);
        System.out.println(output);
    }
}
