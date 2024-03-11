package br.inatel.dm112.EntregaDM112.exception;

import br.inatel.dm112.EntregaDM112.model.Order;

public class OrderAlreadyDeliveredException extends RuntimeException{

    public OrderAlreadyDeliveredException(Order order) {
        super("Order with orderNumber: " + order.getNumber() + " already delivered");
    }
}
