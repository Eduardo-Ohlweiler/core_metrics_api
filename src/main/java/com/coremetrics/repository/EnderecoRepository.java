package com.coremetrics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coremetrics.model.Endereco;
import com.coremetrics.model.Usuario;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    List<Endereco> findByPessoaIdAndUsuario(Integer pessoaId, Usuario usuario);

}
