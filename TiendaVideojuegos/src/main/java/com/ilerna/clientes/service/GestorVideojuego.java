/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilerna.clientes.service;

import com.ilerna.clientes.database.Conexion;
import com.ilerna.clientes.entity.Videojuego;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class GestorVideojuego {
    Conexion c = new Conexion();
    
    public List<Videojuego> listar() throws SQLException {
        Statement consulta = c.conectar().createStatement();
        ResultSet rs = consulta.executeQuery("SELECT * FROM videojuego");
        List<Videojuego> lista = new ArrayList<>();

        while (rs.next()) {
            Videojuego v = new Videojuego(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("tematica"),
                    rs.getInt("precio"),
                    rs.getString("disponibilidad")
            );
            lista.add(v);
        }
        rs.close();
        consulta.close();
        return lista;
    }
}
