package br.inatel.dm112.EntregaDM112.exception;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(int orderNumber) {
        super("Order with number id: " + orderNumber + " not found");
    }
}
