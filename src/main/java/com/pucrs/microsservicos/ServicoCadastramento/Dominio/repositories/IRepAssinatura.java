package com.pucrs.microsservicos.ServicoCadastramento.Dominio.repositories;

import com.pucrs.microsservicos.ServicoCadastramento.Dominio.models.Assinatura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepAssinatura extends JpaRepository<Assinatura, Long> {
    public Assinatura findByCodigo(Long codigo);

}
