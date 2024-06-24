package com.pucrs.microsservicos;

import com.pucrs.microsservicos.ServicoAssinaturasValidas.Dominio.listeners.PagServAssValListener;
import com.pucrs.microsservicos.ServicoAssinaturasValidas.Dominio.repositories.IRepAssinaturaValida;
import com.pucrs.microsservicos.ServicoCadastramento.Dominio.listeners.PagServCadListener;
import com.pucrs.microsservicos.ServicoCadastramento.Dominio.models.Assinatura;
import com.pucrs.microsservicos.ServicoCadastramento.Dominio.repositories.IRepAssinatura;
import com.pucrs.microsservicos.ServicoPagamentos.Dominio.events.PagServAssValEvent;
import com.pucrs.microsservicos.ServicoPagamentos.Dominio.events.PagServCadEvent;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class MicrosservicosApplicationTests {

    @Mock
    private IRepAssinaturaValida repAssinaturaValida;

    @Mock
    private IRepAssinatura repAssinatura;

    @InjectMocks
    private PagServAssValListener pagServAssValListener;

    @InjectMocks
    private PagServCadListener pagServCadListener;

    @Test
    void contextLoads() {
    }

    @Test
    void testHandlePagServAssValEvent() {
        MockitoAnnotations.openMocks(this);
        PagServAssValEvent event = new PagServAssValEvent(1L, 100.0f, 10, 6, 2024);

        pagServAssValListener.handlePagServAssValEvent(event);

        verify(repAssinaturaValida, times(1)).deleteById(1L);
    }

    @Test
    void testHandlePagServCadEvent() {
        MockitoAnnotations.openMocks(this);
        PagServCadEvent event = new PagServCadEvent(1L, 100.0f, 10, 6, 2024);
        Assinatura assinatura = new Assinatura();
        assinatura.setFimVigencia(LocalDate.now());

        when(repAssinatura.findById(1L)).thenReturn(Optional.of(assinatura));

        pagServCadListener.handlePagServCadEvent(event);

        verify(repAssinatura, times(1)).save(assinatura);
    }
}
