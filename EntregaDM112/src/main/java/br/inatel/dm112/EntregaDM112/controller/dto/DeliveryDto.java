package br.inatel.dm112.EntregaDM112.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryDto {

    private int orderNumber;
    private String receiverCpf;
    private LocalDate deliveredDate;
}
