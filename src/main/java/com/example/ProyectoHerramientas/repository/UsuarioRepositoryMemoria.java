package com.example.ProyectoHerramientas.repository;

import com.example.ProyectoHerramientas.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UsuarioRepositoryMemoria {
    private Map<String, Usuario> usuarios = new HashMap<>();

    public UsuarioRepositoryMemoria() {
        // usuarios de ejemplo
        usuarios.put("admin", new Usuario("admin", "1234"));
        usuarios.put("user", new Usuario("user", "abcd"));
    }

    public Usuario findByUsername(String username) {
        return usuarios.get(username);
    }
}