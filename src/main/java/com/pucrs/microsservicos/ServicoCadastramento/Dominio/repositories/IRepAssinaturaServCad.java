package com.pucrs.microsservicos.ServicoCadastramento.Dominio.repositories;

import com.pucrs.microsservicos.ServicoCadastramento.Dominio.models.Assinatura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepAssinaturaServCad extends JpaRepository<Assinatura, Long> {
    public Assinatura findByCodigo(Long codigo);
    public List<Assinatura> findByCliente_Codigo(Long codCli);
    public List<Assinatura> findByAplicativo_Codigo(Long codApp);

}
