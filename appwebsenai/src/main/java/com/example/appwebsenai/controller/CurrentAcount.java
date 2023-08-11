package com.example.appwebsenai.controller;

import com.example.appwebsenai.model.Conta;
import com.example.appwebsenai.model.CurrentAccountPF;

import javax.websocket.server.PathParam;

public interface CurrentAcount {

    Double sacar(Double quantidade, Conta conta);

    void depositar(Double quantidade, Conta conta);

    void transferir(Long contaOrigem, Long contaDestino, Double valora);

    Double consultaSaldo(CurrentAccountPF conta);

}