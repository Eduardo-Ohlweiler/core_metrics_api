package com.coremetrics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coremetrics.model.Pessoa;
import com.coremetrics.repository.PessoaRepository;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(Integer id) {
        return pessoaRepository.findById(id);
    }

    public Optional<Pessoa> findByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void deleteById(Integer id) {
        pessoaRepository.deleteById(id);
    }
}
