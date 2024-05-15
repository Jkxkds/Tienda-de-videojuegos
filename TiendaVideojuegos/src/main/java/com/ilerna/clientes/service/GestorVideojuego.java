/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilerna.clientes.service;

import com.ilerna.clientes.database.Conexion;
import com.ilerna.clientes.entity.Videojuego;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alumno
 */
@Service
public class GestorVideojuego {
    Conexion c = new Conexion();
    
    public List<Videojuego> listar() throws SQLException {
        Statement consulta = c.conectar().createStatement();
        ResultSet rs = consulta.executeQuery("SELECT * FROM videojuego");
        List<Videojuego> lista = new ArrayList<>();

        while (rs.next()) {
            Videojuego v = new Videojuego(
                    rs.getInt("id_videojuego"),
                    rs.getString("nombre"),
                    rs.getInt("precio")
            );
            lista.add(v);
        }
        rs.close();
        consulta.close();
        return lista;
    }
    
   public void agregarVideojuego(Videojuego videojuego) throws SQLException {
    String query = "INSERT INTO videojuego (nombre, precio) VALUES (?, ?)";
    try (PreparedStatement pstmt = c.conectar().prepareStatement(query)) {
        pstmt.setString(1, videojuego.getNombre());
        pstmt.setInt(2, videojuego.getPrecio());
        pstmt.executeUpdate();
    }
}

}
