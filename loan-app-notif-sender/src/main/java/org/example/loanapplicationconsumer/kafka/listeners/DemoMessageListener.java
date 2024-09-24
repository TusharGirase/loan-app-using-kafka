package org.example.loanapplicationconsumer.kafka.listeners;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.example.loanapplicationconsumer.dto.LoanApplicationDTO;
import org.example.loanapplicationconsumer.spring.events.LoanApplicationReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "my-topic")
@Log4j2
public class DemoMessageListener {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private JavaMailSender mailSender;

    @KafkaHandler
    public void consumeMessage(String message) {
        Gson gson = new Gson();
        LoanApplicationDTO loanApplicationDTO = gson.fromJson(message, LoanApplicationDTO.class);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(loanApplicationDTO.getEmail());
        mailMessage.setFrom("MySmartGym <no-reply@mysmartgym.in>");
        mailMessage.setSubject("Regarding loan application");
        mailMessage.setText("Hi " + loanApplicationDTO.getApplicantName() + " your application is received");

        mailSender.send(mailMessage);

        LoanApplicationReceivedEvent loanApplicationReceivedEvent = new LoanApplicationReceivedEvent(this, loanApplicationDTO.getMobileNumber());
        applicationEventPublisher.publishEvent(loanApplicationReceivedEvent);

        log.info("Received Message in group foo:{} ", loanApplicationDTO);
    }

}
