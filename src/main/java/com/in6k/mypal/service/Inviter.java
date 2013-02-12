package com.in6k.mypal.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Inviter {

    public static void sendEmail(String name, String email, double sum) {

        final String username = "Heavyck@gmail.com";
        final String password = "kujhj.ol";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Heavyck@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("Heavyck@mail.ru"));
            message.setSubject("In6k PayPal");
            message.setText("Dear Friend,"
                    + "\n\n Mr." + name + " send to you" + sum + "$, please, create an account in our PayPal system!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}