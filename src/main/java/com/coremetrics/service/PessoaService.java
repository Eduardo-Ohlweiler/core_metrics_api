package com.coremetrics.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coremetrics.model.Pessoa;
import com.coremetrics.model.Usuario;
import com.coremetrics.repository.PessoaRepository;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa findById(Integer id, Usuario usuario) {
        return pessoaRepository.findByIdAndUsuario(id, usuario);
    }

    public Pessoa findByCpf(String cpf, Usuario usuario) {
        return pessoaRepository.findByCpfAndUsuario(cpf, usuario);
    }

    public List<Pessoa> findByNome(String nome, Usuario usuario) {
        return pessoaRepository.findByNomeContainingIgnoreCaseAndUsuario(nome, usuario);
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void deleteById(Integer id) {
        pessoaRepository.deleteById(id);
    }
}
