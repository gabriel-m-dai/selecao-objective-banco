package com.api_banco.objective.api_banco.models;

import jakarta.persistence.*;

@Table(name = "conta")
@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private Float saldo;

    public Conta() {}

    public Conta (String numero, Float saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }
}
