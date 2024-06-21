package com.pucrs.microsservicos.ServicoCadastramento.Interface;

import com.pucrs.microsservicos.ServicoCadastramento.Dominio.models.*;
import com.pucrs.microsservicos.ServicoCadastramento.Dominio.services.ServicoCadastramento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad")
public class Controller {
    
    @Autowired
    private ServicoCadastramento servicoCadastramento;

    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        return servicoCadastramento.listarClientes(); 
    }

    @GetMapping("/aplicativos")
    public List<Aplicativo> listarApps() {
        return servicoCadastramento.listarApps();
    }

    @PostMapping("/assinaturas")
    public ResponseEntity<Assinatura> criaAssinatura(@RequestBody Assinatura novaAssinatura)  {
        Assinatura assinatura = servicoCadastramento.cadastrarAssinatura(novaAssinatura.getCliente().getCodigo(), novaAssinatura.getCodApp().getCodigo());
        return ResponseEntity.ok(assinatura);
    }



}
