package br.inatel.dm112.EntregaDM112.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int orderNumber;
    private String receiverCpf;
    private LocalDateTime deliveredDate;
}
