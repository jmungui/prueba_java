package com.wings.pruebajava.wings.service.Impl;

import com.wings.pruebajava.wings.entity.Usuario;
import com.wings.pruebajava.wings.repository.UsuarioRepository;
import com.wings.pruebajava.wings.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario validarUsuario(String nombreUsuario, String contrasena) {
        return usuarioRepository.findByNombreUsuarioAndContrasena(nombreUsuario, contrasena);
    }
}
