package com.pucrs.microsservicos.ServicoPagamentos.Dominio.dto;

import java.util.Date;

import com.pucrs.microsservicos.ServicoPagamentos.Dominio.models.*;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTOServPag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @ManyToOne
    @JoinColumn(name = "cod_Assinatura")
    private AssinaturaServPag assinatura;
    private Float valorPago;
    private Date dataPagamento;
    
}
