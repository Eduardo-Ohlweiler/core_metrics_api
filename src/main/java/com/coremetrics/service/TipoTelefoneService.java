package com.coremetrics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coremetrics.model.TipoTelefone;
import com.coremetrics.model.Usuario;
import com.coremetrics.repository.TipoTelefoneRepository;

@Service
public class TipoTelefoneService {

    @Autowired
    private TipoTelefoneRepository tipoTelefoneRepository;

    @Autowired
    private UsuarioService usuarioService;  // troquei aqui

    public List<TipoTelefone> listar(String descricao) {
        Usuario usuario = usuarioService.getUsuarioLogado();
        if (usuario == null) {
            throw new RuntimeException("Usuário não está logado");
        }
        if (descricao == null) descricao = "";
        return tipoTelefoneRepository.findTipoTelefoneByDescricao(descricao, usuario.getId());
    }

    public TipoTelefone criar(TipoTelefone tipoTelefone) {
        Usuario usuario = usuarioService.getUsuarioLogado();
        if (usuario == null) {
            throw new RuntimeException("Usuário não está logado");
        }
        tipoTelefone.setUsuario(usuario);
        return tipoTelefoneRepository.save(tipoTelefone);
    }

    public TipoTelefone atualizar(Integer id, TipoTelefone dados) {
        Usuario usuario = usuarioService.getUsuarioLogado();
        if (usuario == null) {
            throw new RuntimeException("Usuário não está logado");
        }
        TipoTelefone tipo = tipoTelefoneRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("TipoTelefone não encontrado"));

        if (!tipo.getUsuario().getId().equals(usuario.getId())) {
            throw new RuntimeException("Acesso negado");
        }

        tipo.setDescricao(dados.getDescricao());
        return tipoTelefoneRepository.save(tipo);
    }

    public void deletar(Integer id) {
        Usuario usuario = usuarioService.getUsuarioLogado();
        if (usuario == null) {
            throw new RuntimeException("Usuário não está logado");
        }
        TipoTelefone tipo = tipoTelefoneRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("TipoTelefone não encontrado"));

        if (!tipo.getUsuario().getId().equals(usuario.getId())) {
            throw new RuntimeException("Acesso negado");
        }

        tipoTelefoneRepository.delete(tipo);
    }
}
