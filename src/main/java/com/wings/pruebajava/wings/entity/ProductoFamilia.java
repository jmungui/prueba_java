package com.wings.pruebajava.wings.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTOS_FAMILIAS")
public class ProductoFamilia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFamilia;

    private String nombreFamilia;

    // getters y setters
    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }
}
