package br.inatel.dm112.EntregaDM112.controller;

import br.inatel.dm112.EntregaDM112.controller.dto.DeliveryDto;
import br.inatel.dm112.EntregaDM112.service.DeliveryService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }


    @PostMapping("/make-delivery")
    @ResponseStatus(HttpStatus.OK)
    public DeliveryDto makeDelivery(@RequestParam @NotNull int orderNumber, @RequestParam @NotNull String receiverCpf) {

        return deliveryService.makeDelivery(orderNumber, receiverCpf);
    }


}
