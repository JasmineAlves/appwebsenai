package com.example.appwebsenai;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //Controlador baseado no padrão de comunicação Rest
public class PersonController {

    List<Person> people = new ArrayList<>();
    int id = 0;

    @GetMapping("/person")
    public Person findPerson(@PathParam("id") int id, @PathParam("name") String name){
        for(Person p : people){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    @DeleteMapping("/person")
    public String deletePerson(@PathParam("name") String name){
        Person person = new Person();
        for(Person p : people) {
            if (p.getName().equals(name)) {
                person = p;

            }
        }
        people.remove(person);

        return "A pessoa com o nome de " + name + "foi deletado";
    }



    @PostMapping("/person")//Vai expor o método p/ alguém de fora acessar
    public Person addPerson(@PathParam("name") String name, @PathParam("sexo") String sexo){
        Person person = new Person();
        person.setName(name);
        person.setSexo(sexo);
        id++;
        person.setId(id);
        people.add(person);
        return person;
    }

    @PutMapping("/person")
    public person updatePerson(@PathParam("id") int, @PathParam("name ") String name) {
        Person p = new Person();
        for (Person person : people){
            if (person.getId() == id){
                person.setName(name);
                p = person;
            }
        }
        return p ;
    }


    @GetMapping("/home")
    public String helloWorld(){
        return "Hello world";
    }
}
