package com.ilerna.clientes.Controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ilerna.clientes.entity.Cliente;
import com.ilerna.clientes.service.GestorCliente;

@Controller
@RequestMapping("/alta")
public class ControllerCliente {

    @Autowired
    private GestorCliente gestorCliente;

    // Método para mostrar el formulario de alta de clientes
    @GetMapping("/formulario")
    public String mostrarFormularioAltaCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "alta-cliente";
    }

    // Método para procesar el formulario de alta de clientes
    @PostMapping("/registrar")
    public String procesarFormularioAltaCliente(@RequestBody String cliente) throws SQLException {
        String[] fields = cliente.split(",");
        String nombre = fields[0].split(":")[1].replaceAll("\"", "");
        String edad = fields[1].split(":")[1].replaceAll("\"", "");
        String telefono = fields[2].split(":")[1].replaceAll("\"", "").replaceAll("}", "");
        Cliente c = new Cliente(nombre, Integer.parseInt(edad), telefono);
        gestorCliente.registrarCliente(c);
        return "redirect:/tienda/";
    }
    
    @GetMapping
    public String defaultRouter() {
        return "redirect:/";
    }
}
