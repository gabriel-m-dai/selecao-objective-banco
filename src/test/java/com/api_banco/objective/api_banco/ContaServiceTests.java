package com.api_banco.objective.api_banco;

import com.api_banco.objective.api_banco.models.Conta;
import com.api_banco.objective.api_banco.services.ContaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ContaServiceTests {
    @Autowired
    private ContaService contaService;

    @Test
    void insereContaRetornaConta() {
        var conta = new Conta("1234", 456.57f);
        var response = this.contaService.criaConta(conta);
        assert response.Data != null;
    }

    @Test
    void insereContaComNumeroRepetidoRetornaErro() {
        var conta1 = new Conta("1234", 456.57f);
        var response1 = this.contaService.criaConta(conta1);
        var conta2 = new Conta("1234", 237.02f);
        var response2 = this.contaService.criaConta(conta2);
        assert response1.Data != null;
        assert response2.Data == null;
        assert response2.Error.equals("Já existe uma conta com o mesmo número");
    }
}
