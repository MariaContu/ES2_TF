package com.pucrs.microsservicos.ServicoCadastramento.Dominio.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Assinatura {
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
}
