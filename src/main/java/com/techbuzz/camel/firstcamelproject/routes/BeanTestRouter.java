package com.techbuzz.camel.firstcamelproject.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class BeanTestRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:bean-test-add?period=5000")
                .bean("calculator", "add")
                .to("log:bean-test-add");

        from("timer:bean-test-sub?period=5000")
                .bean("calculator", "sub")
                .to("log:bean-test-sub");
    }
}

@Component
class Calculator{
    public String add(){
        return "Called Method Adding..";
    }

    public String sub(){
        return "Called Method Subing..";
    }
}