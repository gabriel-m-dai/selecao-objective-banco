package com.api_banco.objective.api_banco.controllers;

import com.api_banco.objective.api_banco.models.Conta;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @GetMapping
    public Conta getConta() {
        return new Conta("0245", 123.45f);
    }

    @PostMapping
    public Conta postConta(@RequestBody Conta conta) {
        return new Conta("0245", 123.45f);
    }
}
