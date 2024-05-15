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
import com.ilerna.clientes.entity.Videojuego;
import com.ilerna.clientes.service.GestorVideojuego;
import java.sql.PreparedStatement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tienda")
public class ControllerVideojuego {

    private final GestorVideojuego gestorVideojuego;

    // Inyecta GestorVideojuego en el constructor
    public ControllerVideojuego(GestorVideojuego gestorVideojuego) {
        this.gestorVideojuego = gestorVideojuego;
    }

    // Método para procesar la solicitud de compra
    @PostMapping("/comprar/")
    public String comprar(@RequestBody List<Map<String, String>> data) {
        try {
            for (Map<String, String> item : data) {
                String nombre = item.get("name");
                double precio = Double.parseDouble(item.get("price"));
                // Crea un nuevo Videojuego con los datos recibidos y lo agrega a la base de datos
                Videojuego videojuego = new Videojuego(nombre, (int) precio);
                gestorVideojuego.agregarVideojuego(videojuego);
            }
            return "Compra realizada con éxito";
        } catch (SQLException ex) {
            Logger.getLogger(ControllerVideojuego.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al procesar la compra";
        } catch (NumberFormatException ex) {
            Logger.getLogger(ControllerVideojuego.class.getName()).log(Level.SEVERE, "Error de formato en el precio", ex);
            return "Error al procesar la compra";
        }
    }
}
