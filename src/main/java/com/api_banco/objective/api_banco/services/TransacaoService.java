package com.api_banco.objective.api_banco.services;

import com.api_banco.objective.api_banco.enums.FormasPagamento;
import com.api_banco.objective.api_banco.models.Transacao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class TransacaoService {
    @Autowired
    private ContaService contaService;
    private float taxaDeServico;

    public Float executaTransacao(Float valor, FormasPagamento formaPagamento) {
        switch (formaPagamento) {
            case credito:
                this.taxaDeServico = 0.05f;
                break;

            case debito:
                this.taxaDeServico = 0.03f;
                break;

            case pix:
                this.taxaDeServico = 0f;
                break;

            default:
                break;

        }

        Float valorAtualizado = (valor * this.taxaDeServico) + valor;
        return valorAtualizado;
    }
}
