package com.coremetrics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coremetrics.model.Telefone;
import com.coremetrics.model.Usuario;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {

    List<Telefone> findByPessoaIdAndUsuario(Integer pessoaId, Usuario usuario);
}
