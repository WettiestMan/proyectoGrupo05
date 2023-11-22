/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Config;

import java.util.Arrays;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.grupo06.Model.EmailSender;
import javax.swing.JOptionPane;
/**
 *
 * @author santi
 */
public class Emailer {
    private Session newSession = null;
    private MimeMessage mimeMessage = null;
    private String[] destinatarios;
    private String asunto;
    private String cuerpo;
    private EmailSender enviador;
    private String emailHost;
    
    public Emailer(String asunto, String cuerpo,
            String[] destinatarios, EmailSender enviador) {
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.enviador = enviador;
        this.destinatarios = destinatarios;
        this.emailHost = "smtp.gmail.com";
    }
    
    public void sendEmail() throws NoSuchProviderException, MessagingException{
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, enviador.usuario(),
                enviador.contrasenaAppl());
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
    }

    public MimeMessage draftEmail() throws MessagingException{
        
        mimeMessage = new MimeMessage(newSession);
        
        Arrays.stream(destinatarios)
            .forEach(mailAddr -> {
                try{
                    mimeMessage.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(mailAddr));
                }catch(MessagingException e){
                    JOptionPane.showMessageDialog(null,
                            e.getCause(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }});
        
        MimeMultipart multiPart = new MimeMultipart();

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(cuerpo, "text/html;charset=UTF-8");
        multiPart.addBodyPart(bodyPart);
        
        mimeMessage.setSubject(asunto);
        mimeMessage.setContent(multiPart);

        return mimeMessage;
    }
    
    public void setupServerProperties(){
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties, null);
    }
}
