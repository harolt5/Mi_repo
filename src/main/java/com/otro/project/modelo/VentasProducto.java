package com.otro.project.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventasproducto")

public class VentasProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private Float importeTotal;
    private String comprador;
    private String fechaDeVenta;
    private String horaDeVenta;
    private String nucleo;
    @Column(nullable = false)
    private String productosVendidos;
    


    public VentasProducto(int id,Float importeTotal, String comprador,String nucleo ,String fechaDeVenta,String horaDeVenta, String productosVendidos) {
        this.id = id;
        this.importeTotal = importeTotal;
        this.comprador = comprador;
        this.nucleo = nucleo;
        this.fechaDeVenta = fechaDeVenta;
        this.horaDeVenta = horaDeVenta;
        this.productosVendidos = productosVendidos;
    }

    public VentasProducto() {
    }
 

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Float getImporteTotal() {
        return this.importeTotal;
    }

    public void setImporteTotal(Float importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getComprador() {
        return this.comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getFechaDeVenta() {
        return this.fechaDeVenta;
    }

    public void setFechaDeVenta(String fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }
    public String getHoraDeVenta() {
        return this.horaDeVenta;
    }

    public void setHoraDeVenta(String horaDeVenta) {
        this.horaDeVenta = horaDeVenta;
    }

    public String getProductosVendidos() {
        return this.productosVendidos;
    }

    public void setProductosVendidos(String productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    public String getNucleo() {
        return this.nucleo;
    }

    public void setNucleo(String nucleo) {
        this.nucleo = nucleo;
    }


}