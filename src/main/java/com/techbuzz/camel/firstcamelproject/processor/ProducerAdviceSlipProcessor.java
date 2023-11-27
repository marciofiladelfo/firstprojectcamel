package com.techbuzz.camel.firstcamelproject.processor;

import com.google.gson.Gson;
import com.techbuzz.camel.firstcamelproject.model.AdviceSlipResponseDto;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ProducerAdviceSlipProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Gson dataFormat = new Gson();
        AdviceSlipResponseDto jsonResponse = dataFormat.fromJson(exchange.getIn().getBody(String.class), AdviceSlipResponseDto.class);

        // Atualize a resposta do Camel com os dados desejados
        exchange.getIn().setBody(jsonResponse.getSlipResponseDto().getCharacterName());
    }
}
