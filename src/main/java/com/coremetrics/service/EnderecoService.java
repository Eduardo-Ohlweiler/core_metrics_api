package com.coremetrics.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coremetrics.model.Endereco;
import com.coremetrics.model.Usuario;
import com.coremetrics.repository.EnderecoRepository;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> findByPessoaAndUsuario(Integer pessoaId, Usuario usuario) {
        return enderecoRepository.findByPessoaIdAndUsuarioId(pessoaId, usuario.getId());
    }

    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public void deleteById(Integer id) {
        enderecoRepository.deleteById(id);
    }
}
