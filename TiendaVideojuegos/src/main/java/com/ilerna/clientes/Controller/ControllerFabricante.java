/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilerna.clientes.Controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ilerna.clientes.service.GestorFabricantes;

/**
 *
 * @author Alumno
 */
@Controller
@RequestMapping("/fabricante")
public class ControllerFabricante {
    
    GestorFabricantes gf = new GestorFabricantes ();
    @GetMapping("/")
    public String crud(Model model){
        System.out.println("This is the moddel:"+ model );
        String valorfinal="./fabricante/listarfabricante";
        try {
            model.addAttribute("fabricantes", gf.listar());
        } catch (SQLException ex) {
            Logger.getLogger(ControllerFabricante.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
    }
    @GetMapping
    public ResponseEntity<String> defaultEndpoint() {
        String message = "Te has confundido, por favor mete el parametro que falta!";
        return ResponseEntity.ok(message);
    }    
}