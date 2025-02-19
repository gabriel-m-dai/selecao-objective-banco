package com.api_banco.objective.api_banco.controllers;

import com.api_banco.objective.api_banco.models.Conta;
import com.api_banco.objective.api_banco.reponses.GenericResponse;
import com.api_banco.objective.api_banco.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    private ContaService service;

    @GetMapping
    public ResponseEntity<Conta> getConta(@RequestParam(value = "numero_conta") String numero) {
            var response = service.obtemPorNumeroDaConta(numero);
            return response.Success ? ResponseEntity.ok().body(response.Data) : ResponseEntity.notFound();
    }

//    @PostMapping
//    public Conta postConta(@RequestBody Conta conta) {
////        return new Conta("0245", 123.45f);
//    }
}
