package com.example.appwebsenai.controller;

import com.example.appwebsenai.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository < Person, Integer > {

}