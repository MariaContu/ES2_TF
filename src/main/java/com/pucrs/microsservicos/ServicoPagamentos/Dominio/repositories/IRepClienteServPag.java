package com.pucrs.microsservicos.ServicoPagamentos.Dominio.repositories;

import com.pucrs.microsservicos.ServicoPagamentos.Dominio.models.ClienteServPag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepClienteServPag extends JpaRepository<ClienteServPag, Long> {
    public ClienteServPag findByNome(String nome);
    public ClienteServPag save(ClienteServPag cliente);

    @Query("SELECT c FROM Cliente c WHERE c.codigo = :codigo")
    public ClienteServPag buscarClientePorCodigo(@Param("codigo") Long codigo);
}
