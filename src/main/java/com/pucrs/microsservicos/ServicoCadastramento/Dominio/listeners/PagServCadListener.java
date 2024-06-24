package com.pucrs.microsservicos.ServicoCadastramento.Dominio.listeners;

import com.pucrs.microsservicos.ServicoPagamentos.Dominio.events.PagServCadEvent;
import com.pucrs.microsservicos.ServicoCadastramento.Dominio.models.Assinatura;
import com.pucrs.microsservicos.ServicoCadastramento.Dominio.repositories.IRepAssinatura;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.pucrs.microsservicos.RabbitMQConfig.QUEUENAME;

import java.util.Optional;

@Component
public class PagServCadListener {

    @Autowired
    private IRepAssinatura repAssinatura;

    @RabbitListener(queues = QUEUENAME)
    public void handlePagServCadEvent(PagServCadEvent event) {
        Optional<Assinatura> assinaturaOpt = repAssinatura.findById(event.getCodAss());
        System.out.println("listener servcad acessado");

        if (assinaturaOpt.isPresent()) {
            Assinatura assinatura = assinaturaOpt.get();
            assinatura.setFimVigencia(assinatura.getFimVigencia().plusMonths(1));
            repAssinatura.save(assinatura);
            System.out.println("servcad funcionou!");
        }
    }
}
