package com.coremetrics.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coremetrics.model.TipoTelefone;
import com.coremetrics.repository.TipoTelefoneRepository;

@Service
public class TipoTelefoneService {

    private final TipoTelefoneRepository tipoTelefoneRepository;

    public TipoTelefoneService(TipoTelefoneRepository tipoTelefoneRepository) {
        this.tipoTelefoneRepository = tipoTelefoneRepository;
    }

    public List<TipoTelefone> findAll() {
        return tipoTelefoneRepository.findAll();
    }

    public TipoTelefone findById(Integer id) {
        return tipoTelefoneRepository.findById(id).orElse(null);
    }

    public TipoTelefone save(TipoTelefone tipoTelefone) {
        return tipoTelefoneRepository.save(tipoTelefone);
    }

    public void deleteById(Integer id) {
        tipoTelefoneRepository.deleteById(id);
    }
}
