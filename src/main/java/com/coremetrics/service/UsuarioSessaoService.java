package com.coremetrics.service;

import org.springframework.stereotype.Service;

import com.coremetrics.model.Usuario;

import jakarta.servlet.http.HttpSession;

@Service
public class UsuarioSessaoService {

    private final HttpSession session;

    public UsuarioSessaoService(HttpSession session) {
        this.session = session;
    }

    public Usuario getUsuarioLogado() {
        return (Usuario) session.getAttribute("usuarioLogado");
    }
}
