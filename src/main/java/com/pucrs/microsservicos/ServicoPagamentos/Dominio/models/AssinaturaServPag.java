package com.pucrs.microsservicos.ServicoPagamentos.Dominio.models;

import java.time.LocalDate;

import com.pucrs.microsservicos.ServicoPagamentos.Dominio.dto.AssinaturaDTOServPag;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AssinaturaServPag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "cod_App")
    private AplicativoServPag aplicativo;

    @ManyToOne
    @JoinColumn(name = "cod_Cli")
    private ClienteServPag cliente;

    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    public AssinaturaDTOServPag convertToDTO() {
        AssinaturaDTOServPag dto = new AssinaturaDTOServPag();
        dto.setCodigo(this.codigo);
        dto.setCliente(this.cliente);
        dto.setCodApp(this.aplicativo);
        dto.setInicioVigencia(this.inicioVigencia);
        dto.setFimVigencia(this.fimVigencia);
        dto.setStatus(this.fimVigencia.isAfter(LocalDate.now()) ? "ATIVA" : "CANCELADA");
        return dto;
    }

}
