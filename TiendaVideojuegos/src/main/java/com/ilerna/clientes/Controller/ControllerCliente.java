package com.ilerna.clientes.Controller;

import com.ilerna.clientes.entity.Cliente;
import com.ilerna.clientes.service.GestorCliente;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerCliente {

    @Autowired
    private GestorCliente gestorCliente;

    // Método para mostrar el formulario de alta de clientes
    @GetMapping("/alta")
    public String mostrarFormularioAltaCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "alta-cliente";
    }

    // Método para procesar el formulario de alta de clientes
    @PostMapping("/alta")
    public String procesarFormularioAltaCliente(Cliente cliente) throws SQLException {
        gestorCliente.registrarCliente(cliente);
        return "redirect:/";
    }
}
