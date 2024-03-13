package br.inatel.dm112.interfaces;

import br.inatel.dm112.model.MailRequestData;
import br.inatel.dm112.model.MailRequestDeliveryData;
import org.springframework.web.bind.annotation.RequestBody;

public interface Email {

    public void sendMail(MailRequestData mailData);

    public void sendDeliveryMail(@RequestBody MailRequestDeliveryData mailData);
}