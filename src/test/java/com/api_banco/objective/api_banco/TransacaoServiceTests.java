package com.api_banco.objective.api_banco;

import com.api_banco.objective.api_banco.enums.FormasPagamento;
import com.api_banco.objective.api_banco.models.Conta;
import com.api_banco.objective.api_banco.models.Transacao;
import com.api_banco.objective.api_banco.services.ContaService;
import com.api_banco.objective.api_banco.services.TransacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransacaoServiceTests {
    @Autowired
    private TransacaoService transacaoService;
    @Autowired
    private ContaService contaService;

    @Test
    public void executaTransacaoRetornaSucesso() {
        Transacao transacao = new Transacao(FormasPagamento.P, "0235", 4.5f);
        Conta conta = new Conta("0235", 100f);
        this.contaService.criaConta(conta);

        var response = this.transacaoService.executaTransacao(transacao);

        assert response.Data != null;
        assert response.Data.getSaldo() == (100f - 4.5f);
    }

    @Test
    public void executaTransacaoCreditoCobraTaxaCincoPorcento() {
        var saldo = 180.37f;
        Transacao transacao = new Transacao(FormasPagamento.C, "0235", 10f);
        Conta conta = new Conta("0235", saldo);
        this.contaService.criaConta(conta);

        var response = this.transacaoService.executaTransacao(transacao);
        var saldoFinal = 169.87f;
        assert response.Data != null;
        assert response.Data.getSaldo() == saldoFinal;
    }

    @Test
    public void executaTransacaoDebitoCobraTaxaTresPorcento() {
        var saldo = 100.3f;
        Transacao transacao = new Transacao(FormasPagamento.D, "0235", 10f);
        Conta conta = new Conta("0235", saldo);
        this.contaService.criaConta(conta);

        var response = this.transacaoService.executaTransacao(transacao);
        var saldoFinal = 90f;
        assert response.Data != null;
        assert response.Data.getSaldo() == saldoFinal;
    }

    @Test
    public void executaTransacaoRetornaErroContaInexistente() {
        Transacao transacao = new Transacao(FormasPagamento.P, "0235", 4.5f);

        var response = this.transacaoService.executaTransacao(transacao);

        assert response.Data == null;
        assert response.Error.equals("Conta não encontrada");
    }

    @Test
    public void executaTransacaoRetornaErroSaldoInsuficiente() {
        Transacao transacao = new Transacao(FormasPagamento.P, "0235", 50f);
        Conta conta = new Conta("0235", 45f);
        this.contaService.criaConta(conta);

        var response = this.transacaoService.executaTransacao(transacao);

        assert response.Error.equals("Saldo insuficiente");
    }
}
