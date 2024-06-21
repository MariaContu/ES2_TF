package com.pucrs.microsservicos.ServicoCadastramento.Dominio.repositories;

import com.pucrs.microsservicos.ServicoCadastramento.Dominio.models.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepAplicativo extends JpaRepository<Aplicativo, Long> {
    public Aplicativo findByNome(String nome);
    public Aplicativo listarPorNome(String nome);
    public Aplicativo listarPorId(Long id);
    public Aplicativo listarPorIdAplicativo(Long idAplicativo);
    public Aplicativo buscarAplicativoPorId(Long aplicativoCodigo);

}
