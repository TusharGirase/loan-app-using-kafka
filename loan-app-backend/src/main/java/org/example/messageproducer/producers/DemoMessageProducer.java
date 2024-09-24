package org.example.messageproducer.producers;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.example.messageproducer.DTO.LoanApplicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class DemoMessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(LoanApplicationDTO loanApplicationDTO) {
        Gson gson = new Gson();
        String json = gson.toJson(loanApplicationDTO);
        kafkaTemplate.send(Topics.MY_TOPIC.toString(), json);
    }

}
