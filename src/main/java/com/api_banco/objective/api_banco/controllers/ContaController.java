package com.api_banco.objective.api_banco.controllers;

import com.api_banco.objective.api_banco.models.Conta;
import com.api_banco.objective.api_banco.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    private ContaService service;

    @GetMapping("/{numero}")
    public Conta getConta(@PathVariable String numero) {
        return service.obtemPorNumeroDaConta(numero);
    }

//    @PostMapping
//    public Conta postConta(@RequestBody Conta conta) {
////        return new Conta("0245", 123.45f);
//    }
}
