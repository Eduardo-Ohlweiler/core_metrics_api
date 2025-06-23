package com.coremetrics.controller;

import com.coremetrics.model.Usuario;
import com.coremetrics.security.JwtUtil;
import com.coremetrics.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Classe para capturar o corpo do JSON enviado no login
    public static class LoginRequest {
        public String login;
        public String senha;
    }

    // Classe para retornar o token JWT
    public static class AuthResponse {
        public String token;

        public AuthResponse(String token) {
            this.token = token;
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest request) {
        Usuario usuario = usuarioService.findByLogin(request.login);
        if (usuario == null) {
            return ResponseEntity.status(401).body("Login inválido");
        }

        if (!passwordEncoder.matches(request.senha, usuario.getSenha())) {
            return ResponseEntity.status(401).body("Senha inválida");
        }

        // Gera o token JWT
        String token = jwtUtil.gerarToken(usuario.getLogin());

        // Retorna o token no corpo da resposta
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
