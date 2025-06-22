package com.coremetrics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coremetrics.model.TipoEndereco;
import com.coremetrics.model.Usuario;

@Repository
public interface TipoEnderecoRepository extends JpaRepository<TipoEndereco, Integer> {

    List<TipoEndereco> findByUsuario(Usuario usuario);
}
