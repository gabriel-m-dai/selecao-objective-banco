package com.api_banco.objective.services;

import com.api_banco.objective.infra.IUnitOfWork;
import com.api_banco.objective.infra.UnitOfWork;
import com.api_banco.objective.models.Conta;
import com.api_banco.objective.reponses.GenericResponse;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    private final UnitOfWork<Conta> unitOfWork;

    public ContaService(UnitOfWork<Conta> unitOfWork) {
        this.unitOfWork = unitOfWork;
    }

    public GenericResponse<Conta> obtemPorNumeroDaConta(String numero) {
        GenericResponse<Conta> response = new GenericResponse<Conta>();
        try {
            response.Data = this.unitOfWork.getContaRepository().findByNumero(numero).orElseThrow(() -> new RuntimeException(""));
            return response;
        }
        catch (Exception e) {
            response.Success = false;
            response.Error = "Conta não encontrada";
            return response;
        }
    }

    public GenericResponse<Conta> criaConta(Conta conta) {
        GenericResponse<Conta> response = new GenericResponse<Conta>();
        try {
            var contaExiste = this.unitOfWork.getContaRepository().findByNumero(conta.getNumero());

            if (contaExiste.isPresent()) {
                response.Success = false;
                response.Error = "Já existe uma conta com o mesmo número";
                return response;
            }

            this.unitOfWork.commit(conta);
            response.Data = conta;
            return response;
        }
        catch (Exception e) {
            response.Success = false;
            response.Error = "Erro ao criar conta";
            return response;
        }
    }

    public void updateConta(Conta conta) {
        this.unitOfWork.commit(conta);
    }
}
