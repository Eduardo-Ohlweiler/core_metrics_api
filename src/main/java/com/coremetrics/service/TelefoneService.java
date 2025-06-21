package com.coremetrics.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coremetrics.model.Telefone;
import com.coremetrics.repository.TelefoneRepository;

@Service
public class TelefoneService {

    private final TelefoneRepository telefoneRepository;

    public TelefoneService(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    public List<Telefone> findAll() {
        return telefoneRepository.findAll();
    }

    public Telefone findById(Integer id) {
        return telefoneRepository.findById(id).orElse(null);
    }

    public Telefone save(Telefone telefone) {
        return telefoneRepository.save(telefone);
    }

    public void deleteById(Integer id) {
        telefoneRepository.deleteById(id);
    }
}
