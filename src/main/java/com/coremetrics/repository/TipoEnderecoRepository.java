package com.coremetrics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coremetrics.model.TipoEndereco;

@Repository
public interface TipoEnderecoRepository extends JpaRepository<TipoEndereco, Integer> {}
