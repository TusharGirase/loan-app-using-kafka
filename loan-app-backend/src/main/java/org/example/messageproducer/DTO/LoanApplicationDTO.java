package org.example.messageproducer.DTO;

import lombok.Data;

@Data
public class LoanApplicationDTO {
    private String applicantName;
    private double amount;
    private String email;
    private String mobileNumber;
}
