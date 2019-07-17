package com.sahan.jms.service.serviceImpl;

import com.sahan.jms.model.Sms;
import com.sahan.jms.producer.JmsProducer;
import com.sahan.jms.repository.SmsRepository;
import com.sahan.jms.service.SmsService;
import com.sahan.jms.utility.SmsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private final SmsRepository smsRepository;
    private final JmsProducer jmsProducer;

    public SmsServiceImpl(SmsRepository smsRepository,
                          JmsProducer jmsProducer) {
        this.smsRepository = smsRepository;
        this.jmsProducer = jmsProducer;
    }

    @Override
    public Sms saveSms(Sms sms) {
        sms.setSendDate(new Date());
        sms.setStatus(SmsStatus.PENDING.getSmsStatusId());
        Sms saveSms = smsRepository.save(sms);
        if (saveSms != null) {
            jmsProducer.send(sms);
        }
        return saveSms;
    }

    @Override
    public List<Sms> getAllSms() {
        List<Sms> smsList = smsRepository.findAll();
        return smsList;
    }
}
