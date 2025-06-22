package com.coremetrics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coremetrics.model.Pessoa;
import com.coremetrics.model.Usuario;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Pessoa findByIdAndUsuario(Integer id, Usuario usuario);
    Pessoa findByCpfAndUsuario(String cpf, Usuario usuario);
    List<Pessoa> findByNomeContainingIgnoreCaseAndUsuario(String nome, Usuario usuario);
}
