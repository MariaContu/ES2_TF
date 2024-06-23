package com.pucrs.microsservicos.ServicoPagamentos.Dominio.services;

import com.pucrs.microsservicos.ServicoPagamentos.Dominio.events.PagServCadEvent;
import com.pucrs.microsservicos.ServicoPagamentos.Dominio.models.*;
import com.pucrs.microsservicos.ServicoPagamentos.Dominio.repositories.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoPagamentos {

    @Autowired
    private EventPublisher eventPublisher;

    @Autowired
    private IRepPagamentoServPag repPagamento;

    @Autowired
    private IRepAssinaturaServPag repAssinatura;

    public Optional<AssinaturaServPag> buscarAssinaturaPorId(Long id) {
        return repAssinatura.findById(id);
    }

    public void registrarPagamento(int dia, int mes, int ano, Long codass, float valorPago) {
        Optional<AssinaturaServPag> assOpt = buscarAssinaturaPorId(codass);

        if (assOpt != null) {
            AssinaturaServPag ass = assOpt.get();
                
            // Criação do pagamento
            PagamentoServPag pagamento = new PagamentoServPag();
            pagamento.setAssinatura(ass);
            pagamento.setValorPago(valorPago);

            Calendar calendar = Calendar.getInstance();
            calendar.set(ano, mes-1, dia);
            Date dataPag = calendar.getTime();

            pagamento.setDataPagamento(dataPag);

            // Salva o pagamento no repositório
            repPagamento.save(pagamento);

            // Publica o evento de pagamento
            PagServCadEvent event = new PagServCadEvent(codass, valorPago, dia, mes, ano);
            eventPublisher.publishPagServCadEvent(event);

        }
    }
    
}
