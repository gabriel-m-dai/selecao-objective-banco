package com.api_banco.objective.controllers;

import com.api_banco.objective.models.Conta;
import com.api_banco.objective.reponses.GenericResponse;
import com.api_banco.objective.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    private ContaService service;

    @GetMapping
    public ResponseEntity<GenericResponse<Conta>> getConta(@RequestParam(value = "numero_conta") String numero) {
            var response = service.obtemPorNumeroDaConta(numero);
            return
                    response.Success ?
                    new ResponseEntity<GenericResponse<Conta>>(response, HttpStatus.OK) :
                    new ResponseEntity<GenericResponse<Conta>>(response, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<GenericResponse<Conta>> postConta(@RequestBody Conta conta) {
        var response = service.criaConta(conta);
        return
                response.Success ?
                new ResponseEntity<GenericResponse<Conta>>(response, HttpStatus.CREATED) :
                new ResponseEntity<GenericResponse<Conta>>(response, HttpStatus.BAD_REQUEST);
    }
}
