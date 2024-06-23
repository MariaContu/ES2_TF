package com.pucrs.microsservicos.ServicoCadastramento.Dominio.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "AplicativoServCad")
public class Aplicativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    private String nome;

    private Float custoMensal;
}
