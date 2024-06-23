package com.pucrs.microsservicos.ServicoPagamentos.Dominio.repositories;

import com.pucrs.microsservicos.ServicoPagamentos.Dominio.models.AplicativoServPag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepAplicativoServPag extends JpaRepository<AplicativoServPag, Long> {
    public AplicativoServPag findByNome(String nome);

    @Query("SELECT c FROM Aplicativo c WHERE c.codigo = :codigo")
    public AplicativoServPag buscarAplicativoPorCodigo(@Param("codigo") Long codigo);

}
