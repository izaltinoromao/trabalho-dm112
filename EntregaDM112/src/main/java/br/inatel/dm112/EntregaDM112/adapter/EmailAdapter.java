package br.inatel.dm112.EntregaDM112.adapter;

import br.inatel.dm112.EntregaDM112.controller.dto.DeliveryDto;
import br.inatel.dm112.EntregaDM112.model.MailRequestData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EmailAdapter {

    @Value("${utility.rest.email.url}")
    private String restURL;

    @Value("${email.sendFromAddress}")
    private String sendFromAddress;

    @Value("${email.sendToAddress}")
    private String sendToAddress;

    @Value("${email.password}")
    private String sendPassAddress;

    private String mailEndpoint = "/mail";

    public void callSendMailService(DeliveryDto deliveryDto) {

        String url = restURL + mailEndpoint ;
        System.out.println("URL: " + url);

        MailRequestData mrd = new MailRequestData(orderNumber, sendFromAddress, sendPassAddress, sendToAddress, content);

        WebClient
                .create(url)
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(mrd), MailRequestData.class)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class).defaultIfEmpty("")
                .log()
                .block();
    }


}
