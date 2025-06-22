package com.coremetrics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coremetrics.model.TipoPessoa;
import com.coremetrics.model.Usuario;

@Repository
public interface TipoPessoaRepository extends JpaRepository<TipoPessoa, Integer> {

    List<TipoPessoa> findByUsuario(Usuario usuario);
}
