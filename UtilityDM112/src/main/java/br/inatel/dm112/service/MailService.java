package br.inatel.dm112.service;

import br.inatel.dm112.adapter.MailAdapter;
import br.inatel.dm112.model.MailRequestData;
import br.inatel.dm112.model.MailRequestDeliveryData;
import br.inatel.dm112.rest.support.UtilityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    MailAdapter sender;

    public void sendMail(MailRequestData mailData) {
        if (mailData.getFrom() == null ||
                mailData.getPassword() == null ||
                mailData.getTo() == null ||
                mailData.getContent() == null) {
            throw new UtilityException("Null values not allowed in MailRequestData.");
        }

        try {
            sender.sendMail(mailData);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UtilityException("Error sending email: " + e.getMessage());
        }
        System.out.println("Email sent success.");
    }

    public void sendDeliveryMail(MailRequestDeliveryData mailData) {
        if (mailData.getFrom() == null ||
                mailData.getPassword() == null ||
                mailData.getTo() == null ||
                mailData.getDeliveryDto() == null) {
            throw new UtilityException("Null values not allowed in MailRequestData.");
        }

        try {
            sender.sendDeliveryMail(mailData);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UtilityException("Error sending email: " + e.getMessage());
        }
        System.out.println("Email sent success.");
    }
}
