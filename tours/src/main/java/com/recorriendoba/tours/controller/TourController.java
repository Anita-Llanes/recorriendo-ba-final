package com.recorriendoba.tours.controller;

import com.recorriendoba.tours.model.*;
import com.recorriendoba.tours.service.*;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tours")

public class TourController {
    
    private final TourService tourService;
    
    public TourController(TourService tourService) {
        this.tourService = tourService;
        }
    
    @GetMapping
    public ResponseEntity<List<TourEntity>> getAllTours() {
        return ResponseEntity.ok(tourService.getAllTours());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourEntity> getTourById(@PathVariable Integer id) {
        return ResponseEntity.ok(tourService.getTourById(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<TourEntity> getTourByName(@PathVariable String name) {
        return ResponseEntity.ok(tourService.getTourByName(name));
    }

    @PostMapping
    public ResponseEntity<TourEntity> addTour(@Valid @RequestBody TourRequest request) {
        return new ResponseEntity<>(tourService.createTour(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TourEntity> updateTour(@PathVariable Integer id, @Valid @RequestBody TourRequest request) {
        return ResponseEntity.ok(tourService.modificarTour(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id) {
        tourService.deleteTour(id);
    }
}




