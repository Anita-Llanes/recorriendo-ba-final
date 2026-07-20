package com.recorriendoba.tours.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items_reserva")
public class ItemReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private TourEntity tour;
    private Integer tourId;
    private Integer cantidad;
    private Double precioUnitario;
        
    private Double precioTotal;
    
    private LocalDate fechaReserva;
    private LocalTime horaReserva;
    private String estadoReserva; 
    private String metodoPago; 
    
    private String nombreCliente;
    private String emailCliente;
        
    private LocalDate fechaCreacion;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDate.now();
        this.estadoReserva = "PENDIENTE";
    }
}