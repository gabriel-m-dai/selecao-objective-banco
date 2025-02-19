package com.api_banco.objective.api_banco.controllers;

import com.api_banco.objective.api_banco.enums.FormasPagamento;
import com.api_banco.objective.api_banco.models.Transacao;
import com.api_banco.objective.api_banco.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    @GetMapping("/{valor}/{formaPagamento}")
    public Float executaTransacao(@PathVariable Float valor, @PathVariable FormasPagamento formaPagamento) {
        return this.transacaoService.executaTransacao(valor, formaPagamento);
    }

    //@RequestBody Transacao transacao
}
