package com.pucrs.microsservicos.ServicoAssinaturasValidas.Dominio.listeners;

import com.pucrs.microsservicos.ServicoAssinaturasValidas.Dominio.models.AssinaturaValida;
import com.pucrs.microsservicos.ServicoAssinaturasValidas.Dominio.repositories.IRepAssinaturaValida;
import com.pucrs.microsservicos.ServicoPagamentos.Dominio.events.PagServAssValEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PagServAssValListener {

    @Autowired
    private IRepAssinaturaValida repAssinaturaValida;

    @RabbitListener(queues = "pagamentos.assinaturasvalidas")
    @CacheEvict(value = "assinaturasValidas", key = "#event.codAss")
    public void handlePagServAssValEvent(PagServAssValEvent event) {
        AssinaturaValida assinaturaValida = new AssinaturaValida();
        assinaturaValida.setCodAss(event.getCodAss());
        // Atualiza a data de fim de vigência conforme a lógica de negócio
        assinaturaValida.setDataFimVigencia(LocalDate.now().plusMonths(1));
        repAssinaturaValida.save(assinaturaValida);
    }
}
