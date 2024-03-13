package br.inatel.dm112.EntregaDM112.adapter;

import br.inatel.dm112.EntregaDM112.model.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class OrderAdapter {

    @Value("${order.rest.url}")
    private String restURL;

    private final String endpoint = "/orders";

    public Order retrieveOrder(int orderNumber) {
        String url = restURL + endpoint + "/" + orderNumber;
        System.out.println("URL: " + url);

        return WebClient.create(url)
                .get()
                .retrieve()
                .bodyToMono(Order.class)
                .block();
    }

    public void makeOrderDelivery(int orderNumber) {

        String url = restURL + endpoint + "/" + orderNumber + "/delivery-confirmation";
        System.out.println("URL: " + url);

        makePUTCallWithEmptyBody(url);
        System.out.println("Delivery successful: " + orderNumber);
    }

    private void makePUTCallWithEmptyBody(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .PUT(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() != HttpStatus.OK.value()) {
                throw new RuntimeException("Error updating Order Payment. statusCode" + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating Order Payment: " + e.getMessage());
        }
    }
}
