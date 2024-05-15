/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilerna.clientes.Controller;

import java.sql.SQLException;
import java.util.List;
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
import com.ilerna.clientes.service.GestorVideojuego;
import java.util.Map;

/**
 * Controlador para manejar las solicitudes relacionadas con los videojuegos.
 * 
 * @author Alumno
 */
@Controller
@RequestMapping("/tienda")
public class ControllerVideojuego {
    
    @GetMapping("/")
    public String crud(Model model) {
        GestorVideojuego gf = new GestorVideojuego();

            try {
                // Aquí puedes agregar atributos al modelo si es necesario
                model.addAttribute("videojuegos", gf.listar());
                return "redirect:/tienda.html"; // Redirige a la página de videojuego en la carpeta static
            } catch (SQLException ex) {
                Logger.getLogger(ControllerVideojuego.class.getName()).log(Level.SEVERE, null, ex);
                return "error"; // En caso de error, redirige a una vista de error
            }
    }
    
    @PostMapping("/comprar/")
    public String comprar(@RequestBody String data) throws JsonProcessingException {
        System.out.println("ME HAS HECHO UNA PETICION DESDE CLIENTE; ENHORABUENA!");
        ObjectMapper objectMapper = new ObjectMapper();
        // Parse the JSON array string into a list of strings

        List<Map<String, String>> unparsedData = objectMapper.readValue(data,new TypeReference<List<Map<String, String>>>() {});
        for (Map<String, String> item : unparsedData) {
            String name = item.get("name");
            String price = item.get("price");
            System.out.println("Name: " + name + ", Price: " + price);
        }
        return "index";//TODO cambiar
    }      
}
