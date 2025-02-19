package com.api_banco.objective.api_banco.services;

import com.api_banco.objective.api_banco.models.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
//    @Autowired
//    private Repository repository;

    public void obtemPorNumeroDaConta(String numero) {
//        return this.repository.findByNumero(numero).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }
}
