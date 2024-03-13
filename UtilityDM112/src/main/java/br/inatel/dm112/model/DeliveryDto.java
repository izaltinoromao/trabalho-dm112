package br.inatel.dm112.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class DeliveryDto {
    private int orderNumber;
    private String receiverCpf;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime deliveredDate;

    public DeliveryDto(int orderNumber, String receiverCpf, LocalDateTime deliveredDate) {
        this.orderNumber = orderNumber;
        this.receiverCpf = receiverCpf;
        this.deliveredDate = deliveredDate;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getReceiverCpf() {
        return receiverCpf;
    }

    public void setReceiverCpf(String receiverCpf) {
        this.receiverCpf = receiverCpf;
    }

    public LocalDateTime getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(LocalDateTime deliveredDate) {
        this.deliveredDate = deliveredDate;
    }
}
