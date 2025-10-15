package com.wings.pruebajava.wings.service;

import com.wings.pruebajava.wings.entity.Usuario;

public interface UsuarioService {
    Usuario validarUsuario(String nombreUsuario, String contrasena);
}
