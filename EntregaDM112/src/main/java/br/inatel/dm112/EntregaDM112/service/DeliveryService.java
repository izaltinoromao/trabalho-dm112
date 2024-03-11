package br.inatel.dm112.EntregaDM112.service;

import br.inatel.dm112.EntregaDM112.adapter.EmailAdapter;
import br.inatel.dm112.EntregaDM112.adapter.OrderAdapter;
import br.inatel.dm112.EntregaDM112.controller.dto.DeliveryDto;
import br.inatel.dm112.EntregaDM112.exception.OrderAlreadyDeliveredException;
import br.inatel.dm112.EntregaDM112.exception.OrderNotFoundException;
import br.inatel.dm112.EntregaDM112.model.Delivery;
import br.inatel.dm112.EntregaDM112.model.Order;
import br.inatel.dm112.EntregaDM112.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DeliveryService {

    private DeliveryRepository deliveryRepository;

    private OrderAdapter orderAdapter;

    private EmailAdapter emailAdapter;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository, OrderAdapter orderAdapter, EmailAdapter emailAdapter) {
        this.deliveryRepository = deliveryRepository;
        this.orderAdapter = orderAdapter;
        this.emailAdapter = emailAdapter;
    }

    public DeliveryDto makeDelivery(int orderNumber, String receiverCpf) {
        Order order = getOrder(orderNumber); // (1) consulta o pedido pelo número

        if (order.getDeliveryStatus() == Order.DELIVERYSTATUS.DELIVERED.ordinal()) {
            throw new OrderAlreadyDeliveredException(order);
        }

        orderAdapter.makeOrderDelivery(order.getNumber()); // (2) atualiza o status do pedido

        DeliveryDto deliveryDto = DeliveryDto.builder()
                .deliveredDate(LocalDate.now())
                .orderNumber(order.getNumber())
                .receiverCpf(receiverCpf)
                .build();

        emailAdapter.callSendMailService(deliveryDto); // (4) envia email com o pdf

        System.out.println("Success on delivery: orderNumber: " + orderNumber);
        return deliveryDto; // (5) retorna sucesso
    }

    private Order getOrder(int orderNumber) {

        Order order;
        try {
            order = orderAdapter.retrieveOrder(orderNumber); // (1) consulta o pedido pelo número
        } catch (Exception e) {
            throw new OrderNotFoundException(orderNumber);
        }
        return order;
    }
}
