package com.wings.pruebajava.wings.service.Impl;

import com.wings.pruebajava.wings.entity.Producto;
import com.wings.pruebajava.wings.repository.ProductoRepository;
import com.wings.pruebajava.wings.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> buscarPorId(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void ellminar(Integer id) {
        productoRepository.deleteById(id);
    }

}
