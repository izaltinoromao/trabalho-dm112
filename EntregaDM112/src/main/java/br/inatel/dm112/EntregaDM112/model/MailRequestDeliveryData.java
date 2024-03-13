package br.inatel.dm112.EntregaDM112.model;

import br.inatel.dm112.EntregaDM112.controller.dto.DeliveryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailRequestDeliveryData {

    private String from;
    private String password;
    private String to;
    private DeliveryDto deliveryDto;

    @Override
    public String toString() {
        return "MailRequestData [from=" + from + ", password=" + password + ", to=" + to + "]";
    }

}
