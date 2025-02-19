package com.api_banco.objective.infra;

import org.springframework.stereotype.Component;

@Component
public interface IUnitOfWork<T> {
    ApiRepository getContaRepository();
    void commit(T entity);
}
