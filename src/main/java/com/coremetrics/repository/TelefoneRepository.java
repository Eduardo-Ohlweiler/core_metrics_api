package com.coremetrics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coremetrics.model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {
    List<Telefone> findByPessoaId(Integer pessoaId);
}
