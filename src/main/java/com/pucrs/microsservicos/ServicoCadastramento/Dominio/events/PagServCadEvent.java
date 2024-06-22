package com.pucrs.microsservicos.ServicoCadastramento.Dominio.events;

import lombok.Getter;

@Getter
public class PagServCadEvent {
    private Long codCli;
    private Long codApp;
    private boolean pagamentoConfirmado;

    public PagServCadEvent(Long codCli, Long codApp, boolean pagamentoConfirmado) {
        this.codCli = codCli;
        this.codApp = codApp;
        this.pagamentoConfirmado = pagamentoConfirmado;
    }
}
