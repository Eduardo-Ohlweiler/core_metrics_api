package com.coremetrics.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coremetrics.model.TipoEndereco;
import com.coremetrics.repository.TipoEnderecoRepository;

@Service
public class TipoEnderecoService {

    private final TipoEnderecoRepository tipoEnderecoRepository;

    public TipoEnderecoService(TipoEnderecoRepository tipoEnderecoRepository) {
        this.tipoEnderecoRepository = tipoEnderecoRepository;
    }

    public List<TipoEndereco> findAll() {
        return tipoEnderecoRepository.findAll();
    }

    public TipoEndereco findById(Integer id) {
        return tipoEnderecoRepository.findById(id).orElse(null);
    }

    public TipoEndereco save(TipoEndereco tipoEndereco) {
        return tipoEnderecoRepository.save(tipoEndereco);
    }

    public void deleteById(Integer id) {
        tipoEnderecoRepository.deleteById(id);
    }
}
