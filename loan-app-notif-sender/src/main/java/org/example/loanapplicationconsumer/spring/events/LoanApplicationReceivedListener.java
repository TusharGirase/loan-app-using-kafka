package org.example.loanapplicationconsumer.spring.events;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class LoanApplicationReceivedListener implements ApplicationListener<LoanApplicationReceivedEvent> {
    @Override
    public void onApplicationEvent(LoanApplicationReceivedEvent event) {
        log.info("Received loan application event: " + event.getMobileNo());

    }
}
