package com.pucrs.microsservicos.ServicoPagamentos.Dominio.repositories;

import com.pucrs.microsservicos.ServicoPagamentos.Dominio.models.Pagamento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepPagamento extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByCodigo(Long codigo);
}
