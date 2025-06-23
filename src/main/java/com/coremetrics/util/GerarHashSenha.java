package com.coremetrics.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GerarHashSenha {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode("admin"); // ou a senha que você quiser
        System.out.println("Hash gerado: " + hash);
    }
}
