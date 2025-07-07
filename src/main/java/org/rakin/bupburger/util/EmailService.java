package org.rakin.bupburger.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class EmailService {
    // Gmail SMTP settings
    private static final String HOST = "smtp.gmail.com";    // Gmail's SMTP server
    private static final String PORT = "587";              // TLS Port
    private static final String FROM_EMAIL = "towfiqrakin267@gmail.com";

    private static final String APP_PASSWORD = "mllo hfvs zumw vagz";

    public static String sendVerificationCode(String toEmail) {
        String verificationCode = generateVerificationCode();

        // Configure SMTP properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", HOST);            // SMTP Host
        properties.put("mail.smtp.port", PORT);            // TLS Port
        properties.put("mail.smtp.auth", "true");          // Enable authentication
        properties.put("mail.smtp.starttls.enable", "true");// Enable STARTTLS

        // Create authenticated session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, APP_PASSWORD);
            }
        });

        try {
            // Create and configure email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("BUPBurger - Email Verification Code");

            // Create HTML content for better formatting
            String htmlContent = String.format(
                "<html><body>" +
                "<h2>Email Verification for BUPBurger</h2>" +
                "<p>Your verification code is: <b>%s</b></p>" +
                "<p>Please enter this code to complete your registration.</p>" +
                "<p>If you didn't request this code, please ignore this email.</p>" +
                "</body></html>",
                verificationCode
            );

            message.setContent(htmlContent, "text/html; charset=utf-8");

            // Send the email
            Transport.send(message);
            return verificationCode;
        } catch (MessagingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // Generates 6-digit code
        return String.valueOf(code);
    }
}
