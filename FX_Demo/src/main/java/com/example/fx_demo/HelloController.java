package com.example.fx_demo;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class HelloController  {
    public TextArea TMessage;

    @FXML
    TextField RecepientAddress;
    @FXML
    TextField SendersAddress;
    @FXML
    TextField SendersPass;


    @FXML
    protected void onSendButtonClick() {

        String To = RecepientAddress.getText();
        String From = SendersAddress.getText();
        String Pass = SendersPass.getText();
        String Message = TMessage.getText();

        String host = "smtp.gmail.com";

        Properties prp = System.getProperties();
        System.out.println("properties = "+prp);

        prp.put("mail.smtp.host",host);
        prp.put("mail.smtp.port","465");
        prp.put("mail.smtp.ssl.enable",true);
        prp.put("mail.smtp.auth",true);

        Session session = Session.getInstance(prp, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(From,Pass);
            }
        });

        MimeMessage msg = new MimeMessage(session);

        try {
            msg.setFrom(From);
            msg.setSubject("TEST Mail by Java Application");
            msg.addRecipient(javax.mail.Message.RecipientType.TO,new InternetAddress(To));

            msg.setText(Message);

            Transport.send(msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}