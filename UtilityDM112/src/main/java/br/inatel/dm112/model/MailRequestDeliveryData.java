package br.inatel.dm112.model;

public class MailRequestDeliveryData {
    private String from;
    private String password;
    private String to;
    private DeliveryDto deliveryDto;

    public MailRequestDeliveryData() {
    }

    public MailRequestDeliveryData(String from, String password, String to, DeliveryDto deliveryDto) {
        this.from = from;
        this.password = password;
        this.to = to;
        this.deliveryDto = deliveryDto;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public DeliveryDto getDeliveryDto() {
        return deliveryDto;
    }

    public void setDeliveryDto(DeliveryDto deliveryDto) {
        this.deliveryDto = deliveryDto;
    }

    @Override
    public String toString() {
        return "MailRequestData [from=" + from + ", password=" + password + ", to=" + to + "]";
    }

}
