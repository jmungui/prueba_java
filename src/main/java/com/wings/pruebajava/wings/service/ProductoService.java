package com.wings.pruebajava.wings.service;

import com.wings.pruebajava.wings.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> listarTodos();
    Optional<Producto> buscarPorId(Integer id);
    Producto guardar(Producto producto);
    void ellminar(Integer id);

}
