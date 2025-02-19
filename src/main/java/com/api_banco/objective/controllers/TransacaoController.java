package com.api_banco.objective.controllers;

import com.api_banco.objective.models.Conta;
import com.api_banco.objective.models.Transacao;
import com.api_banco.objective.reponses.GenericResponse;
import com.api_banco.objective.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<GenericResponse<Conta>> executaTransacao(@RequestBody Transacao transacao) {
        var response = this.transacaoService.executaTransacao(transacao);
        return
                response.Success ?
                new ResponseEntity<GenericResponse<Conta>>(response, HttpStatus.CREATED) :
                new ResponseEntity<GenericResponse<Conta>>(response, HttpStatus.NOT_FOUND);
    }
}
