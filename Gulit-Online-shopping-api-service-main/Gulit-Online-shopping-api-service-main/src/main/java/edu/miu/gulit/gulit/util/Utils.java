package edu.miu.gulit.gulit.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class Utils {


    @Autowired
    private static JavaMailSender mailSender;


    public static void sendEmail(String emailUser,String subject,String text) {

        try {

            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(emailUser);
            email.setSubject(subject);
            email.setText(text);
            mailSender.send(email);
            System.out.println("Email is Sent");
        } catch (Exception ex)
        {System.out.println(ex.getMessage());}
    }



}
