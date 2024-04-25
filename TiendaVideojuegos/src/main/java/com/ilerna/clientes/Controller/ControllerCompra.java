/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilerna.clientes.Controller;

import com.ilerna.clientes.service.GestorCompra;
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
@RequestMapping("/compra")
public class ControllerCompra {
    
    GestorCompra gf = new GestorCompra ();
    @GetMapping("/")
    public String crud(Model model){
        String valorfinal="./compra/listarcompra";
        try {
            model.addAttribute("compras", gf.listar());
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCompra.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
    }
    
}