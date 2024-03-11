package br.inatel.dm112.EntregaDM112.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailRequestData {

    private int orderNumber;
    private String from;
    private String password;
    private String to;
    private byte[] content;

    @Override
    public String toString() {
        return "MailRequestData [from=" + from + ", password=" + password + ", to=" + to + "]";
    }

}
