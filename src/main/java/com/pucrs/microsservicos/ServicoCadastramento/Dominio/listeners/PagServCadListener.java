package com.pucrs.microsservicos.ServicoCadastramento.Dominio.listeners;

import com.pucrs.microsservicos.ServicoPagamentos.Dominio.events.PagServCadEvent;
import com.pucrs.microsservicos.ServicoCadastramento.Dominio.models.Assinatura;
import com.pucrs.microsservicos.ServicoCadastramento.Dominio.repositories.IRepAssinaturaServCad;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.pucrs.microsservicos.RabbitMQConfig.QUEUENAME;

import java.util.Optional;

@Component
public class PagServCadListener {

    private final IRepAssinaturaServCad repAssinatura;

    public PagServCadListener(IRepAssinaturaServCad repAssinatura) {
        this.repAssinatura = repAssinatura;
    }

    @RabbitListener(queues = QUEUENAME)
    public void handlePagServCadEvent(PagServCadEvent event) {
        Optional<Assinatura> assinaturaOpt = repAssinatura.findById(event.getCodAss());

        if (assinaturaOpt.isPresent()) {
            Assinatura assinatura = assinaturaOpt.get();
            // Atualiza a vigência da assinatura conforme a lógica de negócio
            assinatura.setFimVigencia(assinatura.getFimVigencia().plusMonths(1));
            repAssinatura.save(assinatura);
        }
    }
}
