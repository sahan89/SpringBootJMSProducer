package com.sahan.jms.controller;

import com.sahan.jms.model.Sms;
import com.sahan.jms.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SmsController {

    @Autowired
    private final SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping(value = "/sendSms")
    public Sms sendSms(@RequestBody Sms sms) {
        Sms saveSms = smsService.saveSms(sms);
        return saveSms;
    }

    @GetMapping(value = "/getAllSms")
    public List<Sms> getAllSms() {
        List<Sms> smsList = smsService.getAllSms();
        return smsList;
    }
}
