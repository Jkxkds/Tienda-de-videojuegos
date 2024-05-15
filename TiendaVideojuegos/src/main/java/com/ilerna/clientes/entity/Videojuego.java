/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilerna.clientes.entity;

/**
 *
 * @author Alumno
 */
public class Videojuego {
    
    private int id;
    private String nombre;
    private String tematica;
    private int precio;
    
    public Videojuego(){
        
    }

    public Videojuego(String nombre, String tematica, int precio) {
        this.nombre = nombre;
        this.tematica = tematica;
        this.precio = precio;
    }

    public Videojuego(int id, String nombre, String tematica, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.tematica = tematica;
        this.precio = precio;
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

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
