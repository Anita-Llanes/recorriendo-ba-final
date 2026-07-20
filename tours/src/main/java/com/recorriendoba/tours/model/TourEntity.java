package com.recorriendoba.tours.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "tours")
@Data

public class TourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private String imagenUrl;
    private Double precio;
    private Integer stock;
    private Integer duracion;
    private Integer categoryId;
    private String tags;
    private boolean featured;
    private Integer vendidos = 0;
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties("tours")
    private CategoriaEntity categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    /*public int getSales() {
        return ventas;
    }

    public void setSales(int vendidos) {
        this.vendidos = vendidos;
    }*/

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
        return imagenUrl;
    }
    public void setImageUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public TourEntity() {
    }
    public TourEntity(String nombre, String descripcion, Double precio, Integer stock, Integer duracion, String imagen, CategoriaEntity categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.duracion = duracion;
        this.imagenUrl = imagen;
        this.categoria = categoria;
    }
    public void updateFrom(TourEntity updatedTour) {
        this.nombre = updatedTour.getName();
        this.descripcion = updatedTour.getDescription();
        this.precio = updatedTour.getPrice();
        this.stock = updatedTour.getStock();
        this.duracion = updatedTour.getDuration();
        this.imagenUrl = updatedTour.getImagenUrl();
        this.categoria = updatedTour.getCategory();
    }

    public void updateStockAfterPurchase(int cantidad) {
        if (this.stock < cantidad) {
            throw new IllegalArgumentException("Stock insuficiente para el tour: " + this.nombre);
        }
        this.stock -= cantidad;
        this.vendidos += cantidad;
    }

    
}
