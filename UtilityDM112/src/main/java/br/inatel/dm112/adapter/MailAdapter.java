package br.inatel.dm112.adapter;

import br.inatel.dm112.model.MailRequestData;
import br.inatel.dm112.model.MailRequestDeliveryData;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.util.Properties;

public abstract class MailAdapter {

    public void sendMail(MailRequestData mailData) {

        System.out.println("Enviando email do pedido " + mailData.getOrderNumber() + " para: " + mailData.getTo());

        Properties props = getEmailHostProperties();

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailData.getFrom(), mailData.getPassword());
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailData.getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailData.getTo()));
            message.setSubject("Boleto do pedido " + mailData.getOrderNumber());

            Multipart multipart = new MimeMultipart();
            BodyPart messageBodyPartText = new MimeBodyPart(); // texto
            messageBodyPartText.setText("Boleto do pedido " + mailData.getOrderNumber() + " gerado pelo E-comerce DM112.");
            multipart.addBodyPart(messageBodyPartText);

            BodyPart messageBodyPartAtt = new MimeBodyPart(); // anexo
            ByteArrayDataSource source = new ByteArrayDataSource(mailData.getContent(), "application/pdf");
            source.setName("Boleto" + mailData.getOrderNumber() + ".pdf");

            messageBodyPartAtt.setDataHandler(new DataHandler(source));
            messageBodyPartAtt.setFileName("Boleto_Venda" + mailData.getOrderNumber() + ".pdf");
            multipart.addBodyPart(messageBodyPartAtt);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Email sent successfully....");
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected abstract Properties getEmailHostProperties();

    public void sendDeliveryMail(MailRequestDeliveryData mailData) {
        System.out.println("Enviando email da entrega do pedido " + mailData.getDeliveryDto().getOrderNumber() + " para: " + mailData.getTo());

        Properties props = getEmailHostProperties();

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailData.getFrom(), mailData.getPassword());
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailData.getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailData.getTo()));
            message.setSubject("Dados da entrega do pedido " + mailData.getDeliveryDto().getOrderNumber());

            Multipart multipart = new MimeMultipart();
            BodyPart messageBodyPartText = new MimeBodyPart(); // texto
            messageBodyPartText.setText("Entrega: " + mailData.getDeliveryDto().getOrderNumber() + " foi recebido por: CPF:" +
                    mailData.getDeliveryDto().getReceiverCpf() + " na data e hora: " + mailData.getDeliveryDto().getDeliveredDate());
            multipart.addBodyPart(messageBodyPartText);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Email sent successfully....");
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
