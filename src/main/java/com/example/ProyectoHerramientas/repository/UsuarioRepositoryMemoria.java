package com.example.ProyectoHerramientas.repository;

import com.example.ProyectoHerramientas.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UsuarioRepositoryMemoria {
    private Map<String, Usuario> usuarios = new HashMap<>();

    public UsuarioRepositoryMemoria() {
        // usuario de ejemplo
        usuarios.put("juan", new Usuario("juan", "1234"));
    }

    public Usuario findByUsername(String username) {
        return usuarios.get(username);
    }
}