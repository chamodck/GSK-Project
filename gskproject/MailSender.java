/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gskproject;

/**
 *
 * @author sumi
 */
import static gskproject.Email.filePath;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

public class MailSender {

    final String senderEmailID = "sumithmshan@gmail.com";//sender email address
    //static int finalCout=0;
    /*following link is for setup email authentication
    https://www.google.com/settings/security/lesssecureapps*/
    
    final String senderPassword = "mtr4592hds";//password
    final String emailSMTPserver = "smtp.gmail.com";
    final String emailServerPort = "587";//gmail port
    String receiverEmailID = null;
    String emailSubject = null;
    String emailBody = null;
    
/*This is the constructor written for send email. This runs in Email class(send button)*/
    public MailSender(String receiverEmailID, String emailSubject, String emailBody) {
        this.receiverEmailID = receiverEmailID;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;

        Properties props = new Properties();
        props.put("mail.smtp.user", senderEmailID);
        props.put("mail.smtp.host", emailSMTPserver);
        props.put("mail.smtp.port", emailServerPort);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
// props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", emailServerPort);
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        SecurityManager security = System.getSecurityManager();

        try {
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
// session.setDebug(true);

            Message msg = new MimeMessage(session);
            //msg.setText(emailBody);//set the contains in the email body
            msg.setSubject(emailSubject);//set the subject in the email
            msg.setFrom(new InternetAddress(senderEmailID));//sender email
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(receiverEmailID));
            
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(emailBody);//set the contains in the email body
            
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
                
            messageBodyPart = new MimeBodyPart();
            DataSource sourse = new FileDataSource(filePath);//get the file path from the jFileChooser
            messageBodyPart.setDataHandler(new DataHandler(sourse));
            messageBodyPart.setFileName("Attachement");
            multipart.addBodyPart(messageBodyPart);
            msg.setContent(multipart);
             
            Transport.send(msg);
            //finalCout=1;
            //JOptionPane.showMessageDialog(this, "Email send successfully");
            System.out.println("send successfully");
            //return 1;
        } catch (Exception mex) {
            System.out.println("Error occured while sending email");
        }
        
    }
/*this will configure the SMTP Authentication*/
    private class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(senderEmailID, senderPassword);
        }
    }

}
/*
// parent component of the dialog 
JFrame parentFrame = new JFrame();
 
JFileChooser fileChooser = new JFileChooser();
fileChooser.setDialogTitle("Specify a file to save");   
 
int userSelection = fileChooser.showSaveDialog(parentFrame);
 
if (userSelection == JFileChooser.APPROVE_OPTION) {
    File fileToSave = fileChooser.getSelectedFile();
    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
}

*/