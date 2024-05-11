/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilerna.clientes.Controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ilerna.clientes.service.GestorVideojuego;

/**
 * Controlador para manejar las solicitudes relacionadas con los videojuegos.
 * 
 * @author Alumno
 */
@Controller
@RequestMapping("/videojuego")
public class ControllerVideojuego {
    
    @GetMapping("/")
    public String crud(Model model) {
        GestorVideojuego gf = new GestorVideojuego();

        try {
            // Aquí puedes agregar atributos al modelo si es necesario
            model.addAttribute("videojuego", gf.listar());
            return "redirect:/videojuego.html"; // Redirige a la página de videojuego en la carpeta static
        } catch (SQLException ex) {
            Logger.getLogger(ControllerVideojuego.class.getName()).log(Level.SEVERE, null, ex);
            return "error"; // En caso de error, redirige a una vista de error
        }
    }
}
