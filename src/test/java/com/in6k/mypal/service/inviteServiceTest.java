package com.in6k.mypal.service;

import org.junit.Test;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import static junit.framework.Assert.fail;

public class inviteServiceTest {
    String name = "Vladyslav";
    String email = "Heavick@yandex.ru";
    double sum = 1000000.0;

    @Test
    public void shouldCatchException() {
        try {
            InviteService.sendEmail(name, email, sum);
        }
        catch (Exception e) {
            fail("working");
        }

    }

    @Test
    public void doTaskSuccess() throws MessagingException {
        Wiser wiser = new Wiser();
        wiser.setPort(2500);
        wiser.start();

        for (WiserMessage message : wiser.getMessages()) {
            String envelopeSender = message.getEnvelopeSender();
            String envelopeReceiver = message.getEnvelopeReceiver();

            MimeMessage mess = message.getMimeMessage();

            InviteService.sendEmail(name, email, sum);
        }


    }


}
