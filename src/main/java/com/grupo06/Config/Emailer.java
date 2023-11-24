/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Config;

import java.io.File;
import java.io.IOException;
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

import com.grupo06.Resourses.EmailSender;
import javax.swing.JOptionPane;

/**
 * La clase Emailer ofrece clases y atributos para crear y enviar correos
 * electrónicos, se utiliza de la siguiente manera:<br>
 * 
 * <code>
 * Emailer em = new Emailer(...);<br>
 * em.setupServerProperties();<br>
 * em.draftEmail(filename //opcional);<br>
 * em.sendEmail();<br>
 * </code>
 * 
 * @author santi
 */
public class Emailer {
    
    /**
     * Utilizado para configurar las propiedades de la conexión al host de
     * correo electrónico
     */
    private Session newSession = null;
    
    /**
     * Para configurar el correo a enviar
     */
    private MimeMessage mimeMessage = null;
    
    /**
     * La lista de destinatarios
     */
    private String[] destinatarios;
    
    /**
     * Asunto de correo
     */
    private String asunto;
    
    /**
     * Cuerpo del correo
     */
    private String cuerpo;
    
    /**
     * Contiene la información del emisor
     */
    private EmailSender enviador;
    
    /**
     * El host de correo electrónico a conectarse
     */
    private String emailHost;
    
    /**
     * Una dirección a un archivo para adjuntar
     */
    private String dirArchivoAdj;
    
    /**
     * Crea un obejto Emailer sin un archivo adjunto
     * 
     * @param asunto El asunto del correo a enviar
     * @param cuerpo El cuerpo del correo a enviar
     * @param destinatarios La lista de destinatarios
     * @param enviador Un objeto EmailSender con los datos del emisor
     */
    public Emailer(String asunto, String cuerpo,
            String[] destinatarios, EmailSender enviador) {
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.enviador = enviador;
        this.destinatarios = destinatarios;
        this.emailHost = "smtp.gmail.com";
        this.dirArchivoAdj = null;
    }
    
    /**
     * Crea un obejto Emailer con un archivo adjunto
     * 
     * @param asunto El asunto del correo a enviar
     * @param cuerpo El cuerpo del correo a enviar
     * @param destinatarios La lista de destinatarios
     * @param enviador Un objeto EmailSender con los datos del emisor
     * @param direccion La dirección a un archivo a adjuntar en el correo a
     * enviar
     */
    public Emailer(String asunto, String cuerpo,
            String[] destinatarios, EmailSender enviador,
            String direccion){
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.enviador = enviador;
        this.destinatarios = destinatarios;
        this.emailHost = "smtp.gmail.com";
        this.dirArchivoAdj = direccion;
    }
    
    /**
     * Envía un email utilizando el protocolo smtp y el host indicado por
     * <code>emailHost</code> 
     * 
     * @throws NoSuchProviderException Si el host indicado por 
     * <code>emailHost</code> no existe
     * @throws MessagingException Excepción genérica por el uso de 
     * <code>Transport</code>
     */
    public void sendEmail() throws NoSuchProviderException, MessagingException{
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, enviador.usuario(),
                enviador.contrasenaAppl());
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
    }

    /**
     * Genera un correo electrónico con cuerpo usando <code>mimeMessage</code>.
     * Si se llama sobre un objeto con <code>dirArchivoAdj</code> diferente a
     * <code>null</code>, llama a draftEmail(String nombreArchivo) utilizando
     * <code>dirArchivoAdj</code>
     * 
     * @return un <code>MimeMessage</code> con el asunto, cuerpo y archivo
     * adjunto asignados
     * @throws MessagingException Por cualquier inconveniente generado por
     * <code>MimeBodyPart</code> y <code>MimeMultiPart</code>
     * @throws IOException Si el archivo no existe o por
     * algún otro inconveniente generado al leer el archivo (si 
     * <code>dirArchivoAdj</code> es diferente de <code>null</code>).
     */
    public MimeMessage draftEmail() throws MessagingException, IOException{
        
        if(dirArchivoAdj.equals(null)){
            setupReceipients();

            MimeMultipart multiPart = new MimeMultipart();

            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(cuerpo, "text/html;charset=UTF-8");
            multiPart.addBodyPart(bodyPart);

            mimeMessage.setSubject(asunto);
            mimeMessage.setContent(multiPart);

            return mimeMessage;
        }
        return draftEmail(dirArchivoAdj);
    }
    
    /**
     * Genera un correo electrónico con cuerpo y un archivo adjunto usando
     * <code>mimeMessage</code>
     * 
     * @param nombreArchivo la dirección del archivo a adjuntar
     * @return un <code>MimeMessage</code> con el asunto, cuerpo y archivo
     * adjunto asignados
     * @throws MessagingException Por cualquier inconveniente generado por
     * <code>MimeBodyPart</code> y <code>MimeMultiPart</code>
     * @throws IOException Si el archivo no existe o por
     * algún otro inconveniente generado al leer el archivo.
     */
    public MimeMessage draftEmail(String nombreArchivo)
            throws MessagingException, IOException{
        setupReceipients();
        
        MimeMultipart multipart = new MimeMultipart();
        
        MimeBodyPart texto = new MimeBodyPart();
        texto.setContent(cuerpo, "text/html;charset=UTF-8");
        
        MimeBodyPart archivo = new MimeBodyPart();
        archivo.attachFile(new File(nombreArchivo));
        
        multipart.addBodyPart(texto);
        multipart.addBodyPart(archivo);
        
        mimeMessage.setSubject(asunto);
        mimeMessage.setContent(multipart);
        
        return mimeMessage;
    }
    
    /**
     * Método interna llamada por draftEmail(), configura en mimeMessage los
     * destinatarios que van a recibir el correo electrónico
     */
    private void setupReceipients(){
        mimeMessage = new MimeMessage(newSession);

        Arrays.stream(destinatarios)
            .forEach(mailAddr -> {
                try{
                    mimeMessage.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(mailAddr));
                }catch(MessagingException e){
                    JOptionPane.showMessageDialog(null,
                            e.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }});
    }
    
    /**
     * configura el objeto newSession para una conexión por el puerto 587
     * (uno de los puertos con los que Gmail funciona), autentificación activada
     * y tls activado).
     */
    public void setupServerProperties(){
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties, null);
    }
}
