package com.example.firecrud.model;

public class user {
    String Nombre, Apaterno, Amaterno;
    public user(){}

    public user(String nombre, String apaterno, String amaterno) {
        Nombre = nombre;
        Apaterno = apaterno;
        Amaterno = amaterno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApaterno() {
        return Apaterno;
    }

    public void setApaterno(String apaterno) {
        Apaterno = apaterno;
    }

    public String getAmaterno() {
        return Amaterno;
    }

    public void setAmaterno(String amaterno) {
        Amaterno = amaterno;
    }
}
