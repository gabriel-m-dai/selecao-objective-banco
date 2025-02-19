package com.api_banco.objective.api_banco.controllers;

import com.api_banco.objective.api_banco.models.Conta;
import com.api_banco.objective.api_banco.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    private ContaService service;

    @GetMapping
    public Conta getConta(@RequestParam(value = "numero_conta") String numero) {
        try {
            return service.obtemPorNumeroDaConta(numero);
        }
        catch (Exception e){
            return new Conta("Conta não encotrada", 0.0f);
        }

    }

//    @PostMapping
//    public Conta postConta(@RequestBody Conta conta) {
////        return new Conta("0245", 123.45f);
//    }
}
