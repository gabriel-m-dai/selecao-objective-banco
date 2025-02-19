package com.api_banco.objective.infra;

import com.api_banco.objective.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public interface ApiRepository extends JpaRepository<Conta, Long> {
    Optional<Conta> findByNumero(String numero);
}
