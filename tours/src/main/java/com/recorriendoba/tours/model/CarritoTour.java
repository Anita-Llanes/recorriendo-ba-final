package com.recorriendoba.tours.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "carrito_tours")
@Data

public class CarritoTour {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "carrito_id")
    private CarritoEntity carrito;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tour;

    private Integer cantidad;
}
