package com.coremetrics.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coremetrics.model.Pessoa;
import com.coremetrics.model.Usuario;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    
    Optional<Pessoa> findByCpf(String cpf);

    List<Pessoa> findByUsuario(Usuario usuario);
}
