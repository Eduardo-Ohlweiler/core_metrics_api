package com.coremetrics.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PessoaService pessoaService;

    // Mostrar formulário para nova pessoa
    @GetMapping("/novo")
    public String novaPessoa(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "pessoa/form"; // Formulário para criar pessoa
    }

    // Salvar pessoa (novo ou edição)
    @PostMapping("/salvar")
    public String salvarPessoa(@ModelAttribute Pessoa pessoa) {
        pessoaService.save(pessoa);
        return "redirect:/pessoas";
    }

    // Editar pessoa - carrega a pessoa e mostra formulário
    @GetMapping("/editar/{id}")
    public String editarPessoa(@PathVariable Integer id, Model model) {
        Pessoa pessoa = pessoaService.findById(id);
        if (pessoa == null) {
            return "redirect:/pessoas?erro=naoEncontrado";
        }
        model.addAttribute("pessoa", pessoa);
        return "pessoa/form"; // Formulário para edição
    }

    // Excluir pessoa
    @GetMapping("/excluir/{id}")
    public String excluirPessoa(@PathVariable Integer id) {
        pessoaService.deleteById(id);
        return "redirect:/pessoas";
    }
}
