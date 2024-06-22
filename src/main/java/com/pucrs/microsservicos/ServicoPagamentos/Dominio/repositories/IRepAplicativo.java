package com.pucrs.microsservicos.ServicoPagamentos.Dominio.repositories;

import com.pucrs.microsservicos.ServicoPagamentos.Dominio.models.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepAplicativo extends JpaRepository<Aplicativo, Long> {
    public Aplicativo findByNome(String nome);

    @Query("SELECT c FROM Aplicativo c WHERE c.codigo = :codigo")
    public Aplicativo buscarAplicativoPorCodigo(@Param("codigo") Long codigo);

}
