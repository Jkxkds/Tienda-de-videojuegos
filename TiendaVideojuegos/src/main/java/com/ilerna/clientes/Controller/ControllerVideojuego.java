/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilerna.clientes.Controller;

import com.ilerna.clientes.service.GestorVideojuego;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Alumno
 */

@Controller
@RequestMapping("/videojuego")
public class ControllerVideojuego {
    GestorVideojuego gf = new GestorVideojuego ();
    @GetMapping("/")
public String crud(Model model){
    String valorfinal = "./videojuego/index.html"; 
    try {
        model.addAttribute("videojuego", gf.listar());
    } catch (SQLException ex) {
        Logger.getLogger(ControllerVideojuego.class.getName()).log(Level.SEVERE, null, ex);
        valorfinal = "error";
    }
    return valorfinal;
}

    
}