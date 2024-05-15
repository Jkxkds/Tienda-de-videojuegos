package com.ilerna.clientes.service;

import com.ilerna.clientes.database.Conexion;
import com.ilerna.clientes.entity.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GestorCliente {
    Conexion c = new Conexion();
    
    public List<Cliente> listar() throws SQLException {
        Statement consulta = c.conectar().createStatement();
        ResultSet rs = consulta.executeQuery("SELECT * FROM compra");
        List<Cliente> lista = new ArrayList<>();

        while (rs.next()) {
            Cliente c = new Cliente(
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("telefono")                  
            );
            lista.add(c);
        }
        rs.close();
        consulta.close();
        return lista;
    }
    
    public void registrarCliente(Cliente cliente) throws SQLException {
        String query = "INSERT INTO cliente (nombre, edad, telefono) VALUES (?, ?, ?)";
        
        try (PreparedStatement pstmt = c.conectar().prepareStatement(query)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setInt(2, cliente.getEdad());
            pstmt.setString(3, cliente.getTelefono());
            pstmt.executeUpdate();
        }
    }
}
