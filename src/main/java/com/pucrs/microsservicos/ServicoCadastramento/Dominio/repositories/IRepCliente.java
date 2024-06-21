package com.pucrs.microsservicos.ServicoCadastramento.Dominio.repositories;

import com.pucrs.microsservicos.ServicoCadastramento.Dominio.models.Cliente;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepCliente extends JpaRepository<Cliente, Long> {
    public Cliente findByNome(String nome);
    public Cliente listarPorNome(String nome);
    public Cliente listarPorId(Long id);
    public Cliente listarPorIdCliente(Long idCliente);
    public Cliente save(Client cliente);

    @Query("SELECT c FROM Cliente c WHERE c.id = :id")
    public Cliente buscarClientePorId(@Param("id") Long id);
}
