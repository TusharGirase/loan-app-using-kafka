package org.example.messageproducer.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.messageproducer.DTO.LoanApplicationDTO;
import org.example.messageproducer.producers.DemoMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MessageProducerController {

    @Autowired
    private DemoMessageProducer demoMessageProducer;

    @PostMapping
    public String postMessage(@RequestBody LoanApplicationDTO loanApplicationDTO) {
        demoMessageProducer.send(loanApplicationDTO);
        return "Message produced";
    }
}
