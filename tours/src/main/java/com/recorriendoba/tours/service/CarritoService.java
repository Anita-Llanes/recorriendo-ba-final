package com.recorriendoba.tours.service;

import com.recorriendoba.tours.exception.StockInsuficienteException;
import com.recorriendoba.tours.model.CarritoEntity;
import com.recorriendoba.tours.model.ItemReserva;
import com.recorriendoba.tours.repository.CarritoRepository;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {

    private final CarritoRepository carritoRepository;

    public CarritoService(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    public CarritoEntity getCarritoById(Integer carritoId) {
        return carritoRepository.findById(carritoId)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
    }

    public CarritoEntity actualizarCantidad(Integer carritoId, Integer tourId, Integer nuevaCantidad) {
        CarritoEntity carrito = getCarritoById(carritoId);
        for (ItemReserva item : carrito.getItems()) {
            if (item.getTourId().equals(tourId)) {
                if (item.getTour().getStock() < nuevaCantidad) {
                    throw new StockInsuficienteException("Stock insuficiente para el tour: " + item.getTour().getNombre());
                }
                item.setCantidad(nuevaCantidad);
                item.setPrecioTotal(item.getPrecioUnitario() * nuevaCantidad);
            }
        }    
    return carritoRepository.save(carrito);
    }

    public CarritoEntity agregarTourAlCarrito(Integer carritoId, Integer tourId) {
        
        return new CarritoEntity(); 
    }

    public void removerTourDelCarrito(Integer carritoId, Integer tourId) {
    }

}

