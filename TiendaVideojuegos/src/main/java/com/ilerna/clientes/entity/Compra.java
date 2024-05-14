/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilerna.clientes.entity;

/**
 *
 * @author Alumno
 */
public class Compra {
    
    private int id_cliente;
    private int id_videojuego;
    private int total;
    
    public Compra(){
        
    }

    public Compra(int id_cliente, int id_videojuego, int total) {
        this.id_cliente = id_cliente;
        this.id_videojuego = id_videojuego;
        this.total = total;
    }
    
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_videojuego() {
        return id_videojuego;
    }

    public void setId_videojuego(int id_videojuego) {
        this.id_videojuego = id_videojuego;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    } 
}
