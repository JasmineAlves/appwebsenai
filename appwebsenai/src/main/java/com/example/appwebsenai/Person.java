package com.example.appwebsenai;

public class Person {


    private Integer id;
    private String name;  //O atributo privado é devido a Convenção do Java
    private String sexo;

    //Método acessor (pegar atributo + definir valor)
    //NOME
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //SEXO
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
