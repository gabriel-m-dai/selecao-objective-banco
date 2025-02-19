package com.api_banco.objective.services;

import com.api_banco.objective.enums.FormasPagamento;
import com.api_banco.objective.models.Conta;
import com.api_banco.objective.models.Transacao;
import com.api_banco.objective.reponses.GenericResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class TransacaoService {
    @Autowired
    private ContaService contaService;
    private float taxaDeServico;

    public GenericResponse<Conta> executaTransacao(Transacao transacao) {
        try {
            var conta = this.contaService.obtemPorNumeroDaConta(transacao.getNumeroDaConta());

            if (!conta.Success) {
                return conta;
            }

            setTaxaDeServico(transacao.getFormaDePagamento());

            var valor = transacao.getValor();
            var valorAtualizado = (valor * this.taxaDeServico) + valor;
            var saldo = conta.Data.getSaldo();

            if (saldo < valorAtualizado) {
                conta.Success = false;
                conta.Error = "Saldo insuficiente";
            }

            conta.Data.setSaldo(saldo -= valorAtualizado);
            this.contaService.updateConta(conta.Data);

            return conta;
        }
        catch (Exception e) {
            var response = new GenericResponse<Conta>();
            response.Success = false;
            response.Error = "Erro ao efetuar transação";
            return response;
        }

    }

    private void setTaxaDeServico(FormasPagamento formasPagamento) {
        switch (formasPagamento) {
            case C:
                this.taxaDeServico = 0.05f;
                break;

            case D:
                this.taxaDeServico = 0.03f;
                break;

            case P:
                this.taxaDeServico = 0f;
                break;

            default:
                break;
        }
    }
}
