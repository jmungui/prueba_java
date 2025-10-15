package com.wings.pruebajava.wings.repository;

import com.wings.pruebajava.wings.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
}
