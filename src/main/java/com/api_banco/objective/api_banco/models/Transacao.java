package com.api_banco.objective.api_banco.models;

import com.api_banco.objective.api_banco.enums.FormasPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transacao {
    private FormasPagamento formaDePagamaneto;
    private String numeroDaConta;
    private Float valor;
}
