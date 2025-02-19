package com.api_banco.objective.api_banco.services;

import com.api_banco.objective.api_banco.models.Conta;
import com.api_banco.objective.api_banco.reponses.GenericResponse;
import com.api_banco.objective.api_banco.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository repository;

    public GenericResponse<Conta> obtemPorNumeroDaConta(String numero) {
        GenericResponse<Conta> response = new GenericResponse<Conta>();
        try {
            response.Data = this.repository.findByNumero(numero).orElseThrow(() -> new RuntimeException(""));
            return response;
        }
        catch (Exception e) {
            response.Success = false;
            response.Error = "Conta não encontrada";
            return response;
        }


    }
}
