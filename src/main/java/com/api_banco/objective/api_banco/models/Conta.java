package com.api_banco.objective.api_banco.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "conta")
@Entity
public class Conta {
    @Id
    @GeneratedValue()
    private Long id;
    private String numero;
    private Float saldo;
}
