package com.coremetrics.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coremetrics.model.TipoPessoa;
import com.coremetrics.repository.TipoPessoaRepository;

@Service
public class TipoPessoaService {

    private final TipoPessoaRepository tipoPessoaRepository;

    public TipoPessoaService(TipoPessoaRepository tipoPessoaRepository) {
        this.tipoPessoaRepository = tipoPessoaRepository;
    }

    public List<TipoPessoa> findAll() {
        return tipoPessoaRepository.findAll();
    }

    public TipoPessoa findById(Integer id) {
        return tipoPessoaRepository.findById(id).orElse(null);
    }

    public TipoPessoa save(TipoPessoa tipoPessoa) {
        return tipoPessoaRepository.save(tipoPessoa);
    }

    public void deleteById(Integer id) {
        tipoPessoaRepository.deleteById(id);
    }
}
