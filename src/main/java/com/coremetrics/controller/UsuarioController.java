package com.coremetrics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coremetrics.model.Usuario;
import com.coremetrics.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String processarLogin(@ModelAttribute Usuario usuario, HttpSession session, Model model) {
        Usuario usuarioBanco = usuarioService.buscarPorLogin(usuario.getLogin());

        if (usuarioBanco != null && usuarioBanco.getSenha().equals(usuario.getSenha())) {
            session.setAttribute("usuarioLogado", usuarioBanco);
            return "redirect:/pessoas";
        }

        model.addAttribute("erro", "Login ou senha inválidos");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
