package com.api_banco.objective.api_banco.services;

import com.api_banco.objective.api_banco.models.Conta;
import com.api_banco.objective.api_banco.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository repository;

    public Conta obtemPorNumeroDaConta(String numero) {
        return this.repository.findByNumero(numero).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }
}
