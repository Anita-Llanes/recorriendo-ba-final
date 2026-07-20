package com.recorriendoba.tours.service;

import com.recorriendoba.tours.model.CarritoTour;
import com.recorriendoba.tours.repository.CarritoTourRepository;
import org.springframework.stereotype.Service;

@Service
public class CarritoTourService {
    private final CarritoTourRepository repository;

    public CarritoTourService(CarritoTourRepository repository) {
        this.repository = repository;
    }

    public CarritoTour save(CarritoTour carritoTour) {
        return repository.save(carritoTour);
    }

}
