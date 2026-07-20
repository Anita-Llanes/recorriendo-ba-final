package com.recorriendoba.tours.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carritos")
public class CarritoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "carrito_id") 
    private List<ItemReserva> items = new ArrayList<>();
        
    public CarritoEntity() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public List<ItemReserva> getItems() { return items; }
    public void setItems(List<ItemReserva> items) { this.items = items; }

    public Double getTotal() {
        return items.stream()
                .mapToDouble(item -> item.getPrecioUnitario() * item.getCantidad())
                .sum();
    }
}
