package com.pucrs.microsservicos.ServicoCadastramento.Dominio.listeners;

import com.pucrs.microsservicos.ServicoCadastramento.Dominio.events.PagServCadEvent;
import com.pucrs.microsservicos.ServicoCadastramento.Dominio.models.Aplicativo;
import com.pucrs.microsservicos.ServicoCadastramento.Dominio.models.Assinatura;
import com.pucrs.microsservicos.ServicoCadastramento.Dominio.models.Cliente;
import com.pucrs.microsservicos.ServicoCadastramento.Dominio.repositories.IRepAplicativo;
import com.pucrs.microsservicos.ServicoCadastramento.Dominio.repositories.IRepAssinatura;
import com.pucrs.microsservicos.ServicoCadastramento.Dominio.repositories.IRepCliente;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PagServCadListener {

    private final IRepAssinatura repAssinatura;
    private final IRepAplicativo repAplicativo;
    private final IRepCliente repCliente;

    public PagServCadListener(IRepAssinatura repAssinatura, IRepAplicativo repAplicativo, IRepCliente repCliente) {
        this.repAssinatura = repAssinatura;
        this.repAplicativo = repAplicativo;
        this.repCliente = repCliente;
    }

    @EventListener
    public void handlePagServCadEvent(PagServCadEvent event) {
        if (event.isPagamentoConfirmado()) {
            Assinatura novaAssinatura = new Assinatura();
            Cliente cliente = repCliente.buscarClientePorCodigo(event.getCodCli());
            Aplicativo aplicativo = repAplicativo.buscarAplicativoPorCodigo(event.getCodApp());
            novaAssinatura.setCliente(cliente);
            novaAssinatura.setAplicativo(aplicativo);
            novaAssinatura.setInicioVigencia(LocalDate.now());
            novaAssinatura.setFimVigencia(LocalDate.now().plusMonths(1));
            repAssinatura.save(novaAssinatura);
        }
    }
}