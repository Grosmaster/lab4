package com.lab.springboost.jms;

import com.lab.springboost.entity.LogDataEntity;
import com.lab.springboost.entity.NotificationEmailEntity;
import com.lab.springboost.repository.LogDataRepository;
import com.lab.springboost.repository.NotificationEmailRepository;
import com.lab.springboost.repository.PrescriptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.lab.springboost.jms.SenderMessage.generateAndSendEmail;

@Component
public class ReceiveMessage {

    @Autowired
    private LogDataRepository logDataRepository;
    @Autowired
    private NotificationEmailRepository notificationEmailRepository;

    @JmsListener(destination = "sampleQueue")
    public void receiveMessage(String massage) {
        ArrayList<String> email;
        String[] words = massage.split("\\s");
        LogDataEntity data = new LogDataEntity();
        data.setClassname(words[1]);
        data.setTypechange(words[0]);
        data.setValue(massage);
        logDataRepository.save(data);
        for ( NotificationEmailEntity m:notificationEmailRepository.findAll()) {
            sendEmail(massage,m.getEmail());
            System.out.println("Email :" + m.getEmail());
        }

        System.out.println("Received :" + massage);
    }

    private void sendEmail(String massage, String email) {
        try {
            generateAndSendEmail(massage, email);
        } catch (MessagingException e) {
            System.out.println("Error - generateAndSendEmail");
        }
    }
}