package com.example.ProyectoHerramientas.controller;

import com.example.ProyectoHerramientas.entity.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SistemaController {

    @GetMapping("/billetera")
    public String mostrarBilletera(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {
            return "redirect:/login";
        }

        model.addAttribute("usuario", usuario);

        return "Sistema";
    }

}
