package com.sahan.jms.service;

import com.sahan.jms.model.Sms;

import java.util.List;

public interface SmsService {
    Sms saveSms(Sms sms);
    List<Sms> getAllSms();
}
