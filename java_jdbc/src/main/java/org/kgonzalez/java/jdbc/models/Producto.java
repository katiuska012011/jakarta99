package org.kgonzalez.java.jdbc.models;

import java.math.BigDecimal;
import java.util.Date;

public class Producto {

    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Date fechaRegistro;

    public Producto(Long id, String nombre, BigDecimal precio, Date fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }

    public Producto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return id+" nombre  "+nombre+" |"+
                "precio  "+precio+" |"+
                " fecha de registro  "+fechaRegistro;
    }
}
