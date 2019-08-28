package com.shop.Shopaholic.utilities;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;


public class Email {


    public void sendImage(){

        // Recipient's email ID needs to be mentioned.
        String to = "sakshi.agg.512@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "Shopaholic";
        final String username = "shopaholic.innovators@gmail.com";//change accordingly
        final String password = "Innovators@1";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Yayyyy your order is on the way....");

            // This mail has 2 part, the BODY and the embedded image
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(getEmailDetails(), "text/html");
            // add it
            multipart.addBodyPart(messageBodyPart);

            // second part (the image)
            messageBodyPart = new MimeBodyPart();

            String absolutePathOfImage = getFilePathFromDesktop("Phone.jpg");
            DataSource fds = new FileDataSource(absolutePathOfImage);

            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");

            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);
            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailDetails(){
        String details="<div class=\"container\">\n" +
                "\n" +
                "    <div>\n" +
                "        <div><p>Dear Customer,</p></div>\n" +
                "        <div>\n" +
                "            <p> Team Shopaholic thanks you for placing your order with us.<br><p></p>\n" +
                "            You can use the order Id for any queries regarding the order.<br><p></p>\n" +
                "            We will dispatch your order at the earliest, and will keep updating you on the status of your order.<br><p></p>\n" +
                "                    Here are the products in your order:</p>\n" +
                "        </div>\n" +
                "\n" +
                "    </div>\n" +
                "    <div>\n" +
                "        <table>\n" +
                "            <tr><td><b>Order Details</b></td><td><b>Delivery Details</b></td></tr>\n" +
                "            <tr><td>Order No:123</td><td>UserName</td></tr>\n" +
                "            <tr><td>Payment Mode:Cash</td><td>Address line1</td></tr>\n" +
                "            <tr><td>Expected Delivery Date:2019/07/07</td><td>Address line1</td></tr>\n" +
                "            <tr><td></td><td>City - Pin</td></tr>\n" +
                "        </table>\n" +
                "    </div>\n" +
                "    <table>\n" +
                "        <tr><h2>Your Order Summary</h2></tr>\n" +
                "        <tr style=\"max-width: 500px; background-color: white;\">\n" +
                "            <td><img src=\"cid:image\" width=\"90\" height=\"90\"/></td>\n" +
                "            <td style=\"adding: 0 1rem;\">\n" +
                "                <a>Comfy Knit Blazer</a>\n" +
                "                <p style=\"margin: 0;padding: 0;\"><span class=\"title\">Color: </span>Blue</p>\n" +
                "                <p style=\"margin: 0;padding: 0;\"><span class=\"title\">Size: </span>M</p>\n" +
                "            </td>\n" +
                "            <td style=\"adding: 0 1rem;\">\n" +
                "                <p style=\"margin: 0;padding: 0;font-weight: bold;\">$20.00</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "\n" +
                "        <tr style=\"max-width: 500px; background-color: white;\">\n" +
                "            <td><img src=\"cid:image\" width=\"90\" height=\"90\"/></td>\n" +
                "            <td style=\"adding: 0 1rem;\">\n" +
                "                <a>Comfy Knit Blazer</a>\n" +
                "                <p style=\"margin: 0;padding: 0;\"><span class=\"title\">Color: </span>Blue</p>\n" +
                "                <p style=\"margin: 0;padding: 0;\"><span class=\"title\">Size: </span>M</p>\n" +
                "            </td>\n" +
                "            <td style=\"adding: 0 1rem;\">\n" +
                "                <p style=\"margin: 0;padding: 0;font-weight: bold;\">$20.00</p>\n" +
                "            </td>\n" +
                "        </tr><tr></tr>\n" +
                "        <tr><td>Total</td><td></td><td><p style=\"margin: 0;padding: 0;font-weight: bold;\">$40.00</p></td></tr>\n" +
                "\n" +
                "    </table>\n" +
                "\n" +
                "    <div><p>Looking forward to your next visit at Shopaholic!!</p></div>\n" +
                "</div>";
        return details;
    }

    private File getFileFromResources1(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

    public String getFilePathFromDesktop(String fileName) {
        return(System.getProperty("user.home") + "/ShopaholicProductImages/" + fileName);

    }
}
