package com.api_banco.objective.api_banco.repository;

import com.api_banco.objective.api_banco.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    Optional<Conta> findByNumero(String numero);
}
