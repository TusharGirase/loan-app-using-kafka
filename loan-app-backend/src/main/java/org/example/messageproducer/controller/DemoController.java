package org.example.messageproducer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DemoController {
    @Value("${loan.app.someprop}")
    private String someprop;


    @GetMapping
    public String getSomeProp() {
        return "{ \"propertyValue\": \"" + someprop + "\" }";
    }
}
