package com.example.appwebsenai.model;

public abstract class Conta {

    private Long numeroConta;

    private Double Saldo;

    public Long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return Saldo;
    }

    public void setSaldo(Double saldo) {
        this.Saldo = saldo;
    }
}