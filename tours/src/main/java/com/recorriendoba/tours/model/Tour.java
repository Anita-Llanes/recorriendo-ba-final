package com.recorriendoba.tours.model;

import java.util.*;
import lombok.*;
import com.recorriendoba.tours.exception.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tour {
    private Integer id;
    private String name;
    private String description;
    private String imageUrl;
    private Integer duration;
    private Double price;
    private Integer stock;
    private String category; 
    private Integer sales = 0;

    public Tour(Integer id, String name, String description, String imageUrl, Integer duration, Double price, Integer stock, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.duration = duration;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.sales = 0;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getSales() {
        return sales;
    }
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public void updateFrom(Tour updatedTour) {
        this.name = updatedTour.getName();
        this.description = updatedTour.getDescription();
        this.imageUrl = updatedTour.getImageUrl();
        this.duration = updatedTour.getDuration();
        this.price = updatedTour.getPrice();
        this.stock = updatedTour.getStock();
        this.category = updatedTour.getCategory();
    }

    public void updateStockAfterPurchase(int quantity) {
        if (this.stock < quantity) {
            throw new StockInsuficienteException("Stock insuficiente para el tour: " + this.name);
        }
        this.stock -= quantity;
        this.sales += quantity;
    }

    public void updateStockAfterPurchase(List<ItemReserva> items) {
        for (ItemReserva item : items) {
            if (this.id != null && this.id.equals(item.getTourId())) {
            if (this.stock < item.getCantidad()) {
                throw new StockInsuficienteException("Stock insuficiente para el tour: " + this.name);
            }
            this.stock -= item.getCantidad();
            this.sales += item.getCantidad();
        }
    }
}

    public Object getCategoryId() {
        throw new UnsupportedOperationException("Unimplemented method 'getCategoryId'");
    }

    
}
