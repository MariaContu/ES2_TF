package com.pucrs.microsservicos.ServicoPagamentos.Interface;

import com.pucrs.microsservicos.ServicoPagamentos.Dominio.services.ServicoPagamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerServPag {

    @Autowired
    private ServicoPagamentos servicoPagamentos;

    @PostMapping("/registrarpagamento")
    public void registrarPagamento(@RequestParam int dia, @RequestParam int mes, @RequestParam int ano,
                                    @RequestParam Long codass, @RequestParam float valorPago) {
        servicoPagamentos.registrarPagamento(dia, mes, ano, codass, valorPago);
    }
}
