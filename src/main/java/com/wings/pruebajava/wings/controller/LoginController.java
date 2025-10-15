package com.wings.pruebajava.wings.controller;

import com.wings.pruebajava.wings.entity.Usuario;
import com.wings.pruebajava.wings.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String validarLogin(@ModelAttribute("usuario") Usuario usuario, Model model) {
        Usuario user = usuarioService.validarUsuario(usuario.getNombreUsuario(), usuario.getContrasena());

        if (user != null) {
            return "redirect:/productos";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }

}
