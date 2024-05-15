package com.ilerna.clientes.entity;

public class Cliente {
    private int id; // Autoincremental, no incluido en el constructor
    private String nombre;
    private int edad;
    private String telefono;

    public Cliente(String nombre, int edad, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
    }

    public Cliente(int id, String nombre, int edad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
    }

    public Cliente() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                '}';
    }

}