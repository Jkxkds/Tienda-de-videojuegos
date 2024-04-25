/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilerna.clientes.service;

import com.ilerna.clientes.database.Conexion;
import com.ilerna.clientes.entity.Compra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class GestorCompra {
    Conexion c = new Conexion();
    
    public List<Compra> listar() throws SQLException {
        Statement consulta = c.conectar().createStatement();
        ResultSet rs = consulta.executeQuery("SELECT * FROM compra");
        List<Compra> lista = new ArrayList<>();

        while (rs.next()) {
            Compra c = new Compra(
                    rs.getInt("id"),
                    rs.getInt("id_cliente"),
                    rs.getInt("id_videojuego"),
                    rs.getInt("total")                  
            );
            lista.add(c);
        }
        rs.close();
        consulta.close();
        return lista;
    }
}

