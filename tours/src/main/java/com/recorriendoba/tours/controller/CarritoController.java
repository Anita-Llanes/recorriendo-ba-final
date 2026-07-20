package com.recorriendoba.tours.controller;

import com.recorriendoba.tours.model.*;
import com.recorriendoba.tours.service.CarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    private final CarritoService carritoService;
    
    
    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @GetMapping("/{carritoId}")
    public ResponseEntity<CarritoEntity> getCarrito(@PathVariable Integer carritoId) {
        return ResponseEntity.ok(carritoService.getCarritoById(carritoId));
    }

    @PutMapping("/{carritoId}/actualizar/{tourId}")
    public ResponseEntity<CarritoEntity> actualizarCantidad(
        @PathVariable Integer carritoId, 
        @PathVariable Integer tourId, 
        @RequestParam Integer nuevaCantidad) {
    
    return ResponseEntity.ok(carritoService.actualizarCantidad(carritoId, tourId, nuevaCantidad));
}

    @PostMapping("/{carritoId}/agregar/{tourId}")
    public ResponseEntity<CarritoEntity> agregarTour(@PathVariable Integer carritoId, @PathVariable Integer tourId) {
        return ResponseEntity.ok(carritoService.agregarTourAlCarrito(carritoId, tourId));
    }

    @DeleteMapping("/{carritoId}/remover/{tourId}")
    public ResponseEntity<Void> removerTour(@PathVariable Integer carritoId, @PathVariable Integer tourId) {
        carritoService.removerTourDelCarrito(carritoId, tourId);
        return ResponseEntity.noContent().build();
    }

}
