package com.api_banco.objective.infra;

import com.api_banco.objective.models.Conta;
import org.springframework.stereotype.Component;
@Component
public class UnitOfWork<T> implements IUnitOfWork<T> {
    private final ApiRepository apiRepository;

    public UnitOfWork(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    @Override
    public ApiRepository getContaRepository() {
        return apiRepository;
    }

    @Override
    public void commit(T entity) {
        this.apiRepository.save((Conta) entity);
    }
}
