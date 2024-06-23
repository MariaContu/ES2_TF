package com.pucrs.microsservicos.ServicoPagamentos.Dominio.repositories;

import com.pucrs.microsservicos.ServicoPagamentos.Dominio.models.AssinaturaServPag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepAssinaturaServPag extends JpaRepository<AssinaturaServPag, Long> {
    public AssinaturaServPag findByCodigo(Long codigo);
    public List<AssinaturaServPag> findByCliente_Codigo(Long codCli);
    public List<AssinaturaServPag> findByAplicativo_Codigo(Long codApp);

}
