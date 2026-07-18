package com.recorriendoba.tours.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.recorriendoba.tours.model.*;
import com.recorriendoba.tours.service.*;
import java.util.List;


@RestController
@RequestMapping("/tours")


public class TourController {
    
    private final TourService tourService;
    private final CategoriaService categoriaService;

    public TourController(TourService tourService, CategoriaService categoriaService) {
        this.tourService = tourService;
        this.categoriaService = categoriaService;
    }
    

    @GetMapping
    public ResponseEntity<?> getAllTours() {
        return ResponseEntity.ok(tourService.getAllTours());
    }

    @GetMapping("/{id}")
    public TourEntity getTour(@PathVariable Integer id) {
        return tourService.getTourById(id);
    }

    @GetMapping("/{name}")
    public Tour getTourEntity(@PathVariable String name) {
        return tourService.getTourByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TourEntity addTour(@RequestBody Tour request) {
        CategoriaEntity categoria = categoriaService.findById(request.getCategoryId());
        TourEntity tour = new TourEntity();
        tour.setName(request.getName());
        tour.setDescription(request.getDescription());
        tour.setPrice(request.getPrice());
        tour.setStock(request.getStock());
        tour.setCategory(categoria);
        tourService.saveTour(tour);
        return tour;
    }

    @PutMapping("/{id}")
    public TourEntity actualizar(@PathVariable Integer id, @RequestBody TourRequest request) {
        tourService.modificarTour(id, request.getName(), request.getDescription(), request.getPrice), request.getStock());
        return tourService.buscarTour(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id) {
        tourService.deleteTour(id);
    }
}




