package com.example.appwebsenai.controller;

import com.example.appwebsenai.model.CurrentAccountPF;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<CurrentAccountPF, Long> {
}