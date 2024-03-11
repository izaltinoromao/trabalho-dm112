package br.inatel.dm112.EntregaDM112.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    public static enum STATUS { FILLED, PENDING, CONFIRMED }

    public static enum DELIVERYSTATUS { ONROUTE, DELIVERED}

    private int number;

    private String cpf;

    private float value;

    private int status;

    private Date orderDate;

    private Date issueDate;

    private Date paymentDate;

    private String email;

    private int deliveryStatus;

    @Override
    public String toString() {
        return "Order [number=" + number + ", cpf=" + cpf + ", value=" + value + ", status=" + status + ", orderDate="
                + orderDate + ", issueDate=" + issueDate + ", paymentDate=" + paymentDate + "]";
    }

}
