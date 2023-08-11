package com.example.appwebsenai.view;

import com.example.appwebsenai.controller.Controller;
import com.example.appwebsenai.model.Person;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonView {

    @Autowired
    Controller controller;
    @GetMapping("/person")
    public Person findPerson(@PathParam("name") String name){
        return controller.findPerson(name);
    }

    @DeleteMapping("/person")
    public String deletePerson(@PathParam("name") String name){
        controller.removePerson(name);

        return "A pessoa de nome " + name + " foi deletada!";
    }

    @PostMapping("/person")
    public Person addPerson(@PathParam("name") String name, @PathParam("sexo") String sexo){
        return controller.addPerson(name, sexo);
    }

    @PutMapping("/person")
    public Person updatePerson(@PathParam("name") String name, @PathParam("sexo") String sexo){
        return controller.editPerson(name, sexo);
    }

    @GetMapping("/all")
    public List<Person> listAll(){
        return controller.listAll();
    }

    @GetMapping("/home")
    public String helloWorld(){
        return "Hello world";
    }

}
