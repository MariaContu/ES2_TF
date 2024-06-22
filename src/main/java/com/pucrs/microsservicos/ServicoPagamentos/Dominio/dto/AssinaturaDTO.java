package com.pucrs.microsservicos.ServicoPagamentos.Dominio.dto;

import java.time.LocalDate;

import com.pucrs.microsservicos.ServicoPagamentos.Dominio.models.*;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssinaturaDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "cod_App")
    private Aplicativo codApp;

    @ManyToOne
    @JoinColumn(name = "cod_Cli")
    private Cliente cliente;

    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
    private String status;
}
