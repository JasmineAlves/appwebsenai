package com.example.appwebsenai.view;

import com.example.appwebsenai.controller.BankController;
import com.example.appwebsenai.model.CurrentAccountPF;
import jakarta.websocket.server.PathParam;
import com.example.appwebsenai.model.AcountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankView {

    @Autowired
    private BankController bancoController;

    @PostMapping("/criaconta")
    public CurrentAccountPF.CurrentAcountPF criarConta(@PathParam("name") String name, @PathParam("type") String type) throws Exception {
        return bancoController.criarConta(name, type);
    }

    @GetMapping("/type")
    public String listAccountType() {
        String text = AcountType.CONTA_CORRENTE + ", " + AcountType.CONTA_POUPANCA;
        return text;
    }

    @GetMapping("/consultaconta")
    public CurrentAccountPF consultaConta(@PathParam("name") String name) {
        return bancoController.consultaConta(name);
    }

    @PutMapping("/transferir")
    public String transferir(@PathParam("contaOrigem") Long contaOrigem, @PathParam("contaDestino") Long contaDestino, @PathParam("valor") Double valor){
        return bancoController.transferir(contaOrigem, contaDestino, valor);
    }


}