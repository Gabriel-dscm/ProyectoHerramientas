package com.example.ProyectoHerramientas.controller;

import com.example.ProyectoHerramientas.entity.Usuario;
import com.example.ProyectoHerramientas.repository.UsuarioRepositoryMemoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepositoryMemoria repo;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // plantilla login.html
    }

    @PostMapping("/login")
    public String procesarLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        Usuario u = repo.findByUsername(username);

        if (u != null && u.getPassword().equals(password)) {
            // guardar en sesión
            session.setAttribute("usuario", u);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        model.addAttribute("usuario", usuario);
        return "home"; // vista principal
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
