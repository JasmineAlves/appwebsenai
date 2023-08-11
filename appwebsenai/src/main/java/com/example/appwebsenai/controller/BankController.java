package com.example.appwebsenai.controller;

import com.example.appwebsenai.model.Conta;
import com.example.appwebsenai.model.CurrentAccountPF;
import com.example.appwebsenai.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankController implements CurrentAcount{

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private Controller controller;

    private Long number = 0L;
    @Override
    public Double sacar(Double quantidade, Conta conta) {
        return null;
    }

    public CurrentAccountPF criarConta(String name, String accountType) throws Exception {
        CurrentAccountPF contaCorrentePF = new CurrentAccountPF();
        StringBuilder message = new StringBuilder();
        if(accountType == null){
            message.append("\n É necessário que você informe o tipo da conta!");
        }
        switch (accountType){
            case "POUPANCA" :
                contaCorrentePF.setAccountType(AcountType.CONTA_POUPANCA);
                break;
            case "CORRENTE" :
                contaCorrentePF.setAccountType(AccuntType.CONTA_CORRENTE);
            default:
                message.append("\n O tipo da conta não é suportado!");
        }
        Person person = controller.findPerson(name);
        if(person != null && contaCorrentePF.getError() == null){
            number++;
            contaCorrentePF.setNumeroConta(number);
            contaCorrentePF.setPerson(person);
            bankRepository.save(contaCorrentePF);
        }else if(contaCorrentePF.getError() == null){
            message.append("\n Pessoa ");
            message.append(name).append(" informada não foi cadastrada");
        }
        if(!message.isEmpty()){
            contaCorrentePF.setError(message.toString());
        }

        return contaCorrentePF;
    }

    public CurrentAccountPF consultaConta(String name){

        List<CurrentAccountPF> contas = (List<CurrentAccountPF>) bankRepository.findAll();

        for(CurrentAccountPF cc : contas){
            if(cc.getPerson() != null && cc.getPerson().getName().equals(name)){
                return cc;
            }
        }
        return null;
    }


    @Override
    public void depositar(Double quantidade, Conta conta) {
        Double total = conta.getSaldo() + quantidade ;
        conta.setSaldo(total);
    }

    @Override
    public String transferir(Long contaOrigem, Long contaDestino, Double valor) {
        String message = "";
        CurrentAccountPF destino = bankRepository.findById(contaDestino).get();
        CurrentAccountPF origem = bankRepository.findById(contaOrigem).get();

        if(origem.getSaldo() >= valor){
            destino.setSaldo(destino.getSaldo() + valor);
            origem.setSaldo(origem.getSaldo() - valor);
            bankRepository.save(destino);
            bankRepository.save(origem);
            message = "A conta do(a) " + destino.getPerson().getName() + " recebeu a transferência no valor de R$ " + valor;
        }else{
            message = message + " Saldo insuficiente para a operação";
        }

        return message;
    }

    @Override
    public Double consultaSaldo(CurrentAccountPF conta) {
        return conta.getSaldo();
    }
}