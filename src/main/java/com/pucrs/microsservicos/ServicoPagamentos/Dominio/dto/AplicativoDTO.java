package com.pucrs.microsservicos.ServicoPagamentos.Dominio.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AplicativoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    private String nome;

    private Float custoMensal;
}

