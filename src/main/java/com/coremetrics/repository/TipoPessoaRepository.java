package com.coremetrics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coremetrics.model.TipoPessoa;

@Repository
public interface TipoPessoaRepository extends JpaRepository<TipoPessoa, Integer> {}
