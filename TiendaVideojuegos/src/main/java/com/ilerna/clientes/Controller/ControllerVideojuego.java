package com.ilerna.clientes.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilerna.clientes.database.Conexion;
import com.ilerna.clientes.service.GestorVideojuego;
import java.sql.PreparedStatement;

@Controller
@RequestMapping("/tienda")
public class ControllerVideojuego {

    @GetMapping("/")
    public String crud(Model model) {
        GestorVideojuego gf = new GestorVideojuego();
        try {
            model.addAttribute("videojuegos", gf.listar());
            return "redirect:/tienda.html";
        } catch (SQLException ex) {
            Logger.getLogger(ControllerVideojuego.class.getName()).log(Level.SEVERE, null, ex);
            return "error";
        }
    }
@PostMapping("/comprar")
public String comprar(@RequestBody String data) {
    try {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, String>> unparsedData = objectMapper.readValue(data, new TypeReference<List<Map<String, String>>>() {
        });

        for (Map<String, String> item : unparsedData) {
            String nombre = item.get("nombre");
            double precio = Double.parseDouble(item.get("precio"));
            System.out.println("Nombre: " + nombre + ", Precio: " + precio);
            registrarCompra(1, 1, precio); // Aquí se deben proporcionar los IDs de cliente y videojuego correctos
        }

        return "redirect:/tienda/";
    } catch (IOException ex) {
        Logger.getLogger(ControllerVideojuego.class.getName()).log(Level.SEVERE, null, ex);
        return "error";
    } catch (NumberFormatException ex) {
        Logger.getLogger(ControllerVideojuego.class.getName()).log(Level.SEVERE, "Error de formato en el precio", ex);
        return "error";
    } catch (SQLException ex) {
        Logger.getLogger(ControllerVideojuego.class.getName()).log(Level.SEVERE, "Error al registrar la compra", ex);
        return "error";
    }
}

public void registrarCompra(int idCliente, int idVideojuego, double total) throws SQLException {
        Conexion c = new Conexion();

    String query = "INSERT INTO compra (id_cliente, id_videojuego, total) VALUES (?, ?, ?)";
    try (PreparedStatement pstmt = c.conectar().prepareStatement(query)) {
        pstmt.setInt(1, idCliente);
        pstmt.setInt(2, idVideojuego);
        pstmt.setDouble(3, total);
        pstmt.executeUpdate();
    }
}

}
