package com.pucrs.microsservicos.ServicoPagamentos.Dominio.repositories;

import com.pucrs.microsservicos.ServicoPagamentos.Dominio.models.PagamentoServPag;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepPagamentoServPag extends JpaRepository<PagamentoServPag, Long> {
    List<PagamentoServPag> findByCodigo(Long codigo);
}
