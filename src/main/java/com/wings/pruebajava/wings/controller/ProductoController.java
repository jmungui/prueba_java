package com.wings.pruebajava.wings.controller;

import com.wings.pruebajava.wings.entity.Producto;
import com.wings.pruebajava.wings.repository.ProductoFamiliaRepository;
import com.wings.pruebajava.wings.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoFamiliaRepository familiaRepository;

    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.listarTodos());
        return "productos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("familias", familiaRepository.findAll());
        return "nuevo_producto";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        if (producto.getFamilia() != null && producto.getFamilia().getIdFamilia() != null) {
            // buscar la familia en la base de datos
            var familia = familiaRepository.findById(producto.getFamilia().getIdFamilia()).orElse(null);
            producto.setFamilia(familia);
        }
        productoService.guardar(producto);
        return "redirect:/productos";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model model) {
        Producto producto = productoService.buscarPorId(id).orElse(null);
        if (producto == null) {
            return "redirect:/productos";
        }
        model.addAttribute("producto", producto);
        model.addAttribute("familias", familiaRepository.findAll());
        return "editar_producto";
    }

    @PostMapping("/actualizar")
    public String actualizarProducto(@ModelAttribute Producto producto) {
        if (producto.getFamilia() != null && producto.getFamilia().getIdFamilia() != null) {
            var familia = familiaRepository.findById(producto.getFamilia().getIdFamilia()).orElse(null);
            producto.setFamilia(familia);
        }
        productoService.guardar(producto);
        return "redirect:/productos";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Integer id) {
        productoService.ellminar(id);
        return "redirect:/productos";
    }

}
