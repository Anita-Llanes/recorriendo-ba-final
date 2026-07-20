package com.recorriendoba.tours.controller;
import com.recorriendoba.tours.model.CarritoTour;
import com.recorriendoba.tours.service.CarritoTourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito-tours")
public class CarritoTourController {
    private final CarritoTourService service;

    public CarritoTourController(CarritoTourService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CarritoTour> addTourToCarrito(@RequestBody CarritoTour carritoTour) {
        return ResponseEntity.ok(service.save(carritoTour));
    }
}