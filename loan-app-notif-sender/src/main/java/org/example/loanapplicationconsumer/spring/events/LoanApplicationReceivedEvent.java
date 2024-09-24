package org.example.loanapplicationconsumer.spring.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
@Getter
public class LoanApplicationReceivedEvent extends ApplicationEvent {

    private String mobileNo;
    public LoanApplicationReceivedEvent(Object source, String mobileNo) {
        super(source);
        this.mobileNo = mobileNo;
    }


}
