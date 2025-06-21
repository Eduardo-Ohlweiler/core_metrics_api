package com.coremetrics.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coremetrics.model.Pessoa;
import com.coremetrics.service.PessoaService;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    // LISTAR TODOS
    @GetMapping
    public String listarPessoas(Model model) {
        List<Pessoa> pessoas = pessoaService.findAll();
        model.addAttribute("pessoas", pessoas);
        return "pessoas/list";
    }

    // EXIBIR FORM DE CADASTRO NOVO
    @GetMapping("/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "pessoas/form";
    }

    // SALVAR NOVO OU EDITAR
    @PostMapping("/salvar")
    public String salvarPessoa(@ModelAttribute Pessoa pessoa) {
        pessoaService.save(pessoa);
        return "redirect:/pessoas";
    }

    // EXIBIR FORM DE EDIÇÃO
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Integer id, Model model) {
        Optional<Pessoa> pessoaOpt = pessoaService.findById(id);
        if (pessoaOpt.isPresent()) {
            model.addAttribute("pessoa", pessoaOpt.get());
            return "pessoas/form";
        } else {
            return "redirect:/pessoas";
        }
    }

    // DELETAR
    @GetMapping("/deletar/{id}")
    public String deletarPessoa(@PathVariable Integer id) {
        pessoaService.deleteById(id);
        return "redirect:/pessoas";
    }
}
