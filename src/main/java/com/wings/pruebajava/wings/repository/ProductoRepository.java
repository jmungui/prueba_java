package com.wings.pruebajava.wings.repository;

import com.wings.pruebajava.wings.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
