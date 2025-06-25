package com.coremetrics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coremetrics.model.TipoTelefone;

public interface TipoTelefoneRepository extends JpaRepository<TipoTelefone, Integer> {

    @Query("SELECT t FROM TipoTelefone t WHERE LOWER(t.descricao) LIKE LOWER(CONCAT('%', :descricao, '%')) AND t.usuario.id = :usuarioId")
    List<TipoTelefone> findTipoTelefoneByDescricao(@Param("descricao") String descricao, @Param("usuarioId") Integer usuarioId);

}
