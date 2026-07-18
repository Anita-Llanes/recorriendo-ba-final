package com.recorriendoba.tours.model;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;






@Entity
@Table(name = "tours")
@Data

public class TourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private Integer duracion;
    private String imagen;
    private Integer vendidos;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties("tours")
    private CategoriaEntity categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrice() {
        return precio;
    }

    public void setPrice(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSales() {
        return vendidos;
    }

    public void setSales(int vendidos) {
        this.vendidos = vendidos;
    }

    public CategoriaEntity getCategory() {
        return categoria;
    }

    public void setCategory(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public Integer getDuration() {
        return duracion;
    }
    public void setDuration(Integer duracion) {
        this.duracion = duracion;
    }

    public String getImageUrl() {
        return imagen;
    }
    public void setImageUrl(String imagen) {
        this.imagen = imagen;
    }

    public TourEntity() {
    }
    public TourEntity(String nombre, String descripcion, Double precio, Integer stock, Integer duracion, String imagen, CategoriaEntity categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.duracion = duracion;
        this.imagen = imagen;
        this.categoria = categoria;
    }
    public void updateFrom(TourEntity updatedTour) {
        this.nombre = updatedTour.getName();
        this.descripcion = updatedTour.getDescription();
        this.precio = updatedTour.getPrice();
        this.stock = updatedTour.getStock();
        this.duracion = updatedTour.getDuration();
        this.imagen = updatedTour.getImageUrl();
        this.categoria = updatedTour.getCategory();
    }

    public void updateStockAfterPurchase(int cantidad) {
        if (this.stock < cantidad) {
            throw new IllegalArgumentException("Stock insuficiente para el tour: " + this.nombre);
        }
        this.stock -= cantidad;
        this.vendidos += cantidad;
    }

    public create 
}

