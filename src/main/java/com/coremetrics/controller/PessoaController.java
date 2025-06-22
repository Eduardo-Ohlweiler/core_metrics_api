package com.coremetrics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coremetrics.model.Pessoa;
import com.coremetrics.model.Usuario;
import com.coremetrics.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    private Usuario getUsuarioLogado() {
        Usuario u = new Usuario();
        u.setId(1);
        return u;
    }

    @GetMapping("/{id}")
    public Pessoa getPessoaById(@PathVariable Integer id) {
        Usuario usuario = getUsuarioLogado();
        return pessoaService.findById(id, usuario);
    }

    @GetMapping("/buscar")
    public List<Pessoa> buscarPessoas(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf) {
        Usuario usuario = getUsuarioLogado();

        if (nome != null && !nome.isEmpty()) {
            return pessoaService.findByNome(nome, usuario);
        }

        if (cpf != null && !cpf.isEmpty()) {
            Pessoa pessoa = pessoaService.findByCpf(cpf, usuario);
            return pessoa != null ? List.of(pessoa) : List.of();
        }

        return List.of();
    }

    @PostMapping
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
        Usuario usuario = getUsuarioLogado();
        pessoa.setUsuario(usuario);
        return pessoaService.save(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletarPessoa(@PathVariable Integer id) {
        pessoaService.deleteById(id);
    }
}
