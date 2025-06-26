package com.coremetrics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.coremetrics.model.Usuario;
import com.coremetrics.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletarPorId(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario getUsuarioLogado() {
        String login = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("Login extraído do SecurityContext: " + login);
        return findByLogin(login);
    }
}
