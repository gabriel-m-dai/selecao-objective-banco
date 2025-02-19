package com.api_banco.objective.models;

import com.api_banco.objective.enums.FormasPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transacao {
    private FormasPagamento formaDePagamento;
    private String numeroDaConta;
    private Float valor;
}
