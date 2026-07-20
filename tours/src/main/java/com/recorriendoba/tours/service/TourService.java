package com.recorriendoba.tours.service;


import com.recorriendoba.tours.repository.TourRepository;
import org.springframework.stereotype.Service;


import com.recorriendoba.tours.exception.*;
import com.recorriendoba.tours.model.*;
import java.util.List;


@Service
public class TourService {
    
    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<TourEntity> getAllTours() {
        return tourRepository.findAll();
    }

    public TourEntity getTourById(Integer id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new TourNoEncontradoException("Tour con ID " + id + " no encontrado"));
    }

    public TourEntity getTourByName(String name) {
        return tourRepository.findByName(name)
                .orElseThrow(() -> new TourNoEncontradoException("Tour con nombre " + name + " no encontrado"));
    }

    public TourEntity createTour(TourRequest request) {
        TourEntity tour = new TourEntity();
        mapearRequestATour(request, tour);
        return tourRepository.save(tour);
    }

    public TourEntity modificarTour(Integer id, TourRequest request) {
        TourEntity existingTour = getTourById(id);
        mapearRequestATour(request, existingTour);
        return tourRepository.save(existingTour);
    }

    public void deleteTour(Integer id) {
        if (!tourRepository.existsById(id)) {
            throw new TourNoEncontradoException("No se puede eliminar, el tour no existe");
        }
        tourRepository.deleteById(id);
    }
    
    private void mapearRequestATour(TourRequest request, TourEntity tour) {
        tour.setName(request.getName());
        tour.setDescription(request.getDescription());
        tour.setImageUrl(request.getImageUrl());
        tour.setCategoryId(request.getCategoryId());
        tour.setPrice(request.getPrice());
        tour.setDuration(request.getDuration());
        tour.setTags(request.getTags());
        tour.setFeatured(request.isFeatured());
    }
}


    /*public TourEntity createTour(TourRequest request) {
        TourEntity tour = new TourEntity();
        tour.setName(request.getName());
        tour.setDescription(request.getDescription());
        tour.setImageUrl(request.getImageUrl());
        tour.setCategoryId(request.getCategoryId());
        tour.setPrice(request.getPrice());
        tour.setDuration(request.getDuration());
        tour.setTags(request.getTags());
        tour.setFeatured(request.isFeatured());
        return tourRepository.save(tour);
    }

}

    
    private final List<Tour> tours = new ArrayList<>();
    private int counterId = 1;

    public TourService() {
        tours.add(new Tour(counterId++, "Tour por el Teatro Colón","Descubre los secretos de cada rincón y vive la experiencia de una visita guiada. Conoce una porción de su historia de más de cien años al servicio de la cultura argentina y mundial. Al recorrer la Sala, el Foyer Principal, la Galería de Bustos y el Salón Dorado, los visitantes pueden absorber detalles asombrosos sobre la arquitectura, las escaleras, sus esculturas o vitreaux.", "https://i.postimg.cc/vBDhnvXH/teatro-colon-fachada-noche-gente.jpg", 1, 25.0, 40, "artistico",1));
            
        tours.add(new Tour(counterId++, "Tour por el Cementerio de la Recoleta","El Cementerio de la Recoleta es uno de los lugares más emblemáticos de Buenos Aires, conocido por su arquitectura impresionante y sus mausoleos históricos. En este tour, los visitantes pueden explorar las tumbas de figuras históricas, artistas y políticos, mientras aprenden sobre la historia y la cultura de Argentina.", "https://i.postimg.cc/J058hM7Z/tumba-cementerio-Recoleta.jpg", 2, 20.0, 25, "misterios y leyendas", 0));

        tours.add(new Tour(counterId++, "Tour por el barrio de San Telmo","San Telmo es uno de los barrios más antiguos y pintorescos de Buenos Aires, conocido por su arquitectura colonial, sus calles empedradas y su vibrante escena cultural. En este tour, los visitantes pueden explorar las plazas históricas, los mercados de antigüedades y disfrutar de la música y el arte callejero que caracteriza a este barrio.", "https://i.postimg.cc/3NX7Bt6T/feria-de-san-telmo.jpg", 2, 15.0, 30, "iconicos", 0));

        tours.add(new Tour(counterId++, "Tour nocturno por la Avenida Corrientes","La Avenida Corrientes es famosa por su vida nocturna, sus teatros y librerías. En este tour, los visitantes pueden disfrutar de un recorrido por los teatros históricos, descubrir las librerías emblemáticas y experimentar la vibrante cultura de la ciudad a través de su gastronomía y entretenimiento.", "https://i.postimg.cc/XYwzNx1R/obelisco-noche-gente-luces.jpg", 3, 30.0, 20, "nocturnos", 0));

        tours.add(new Tour(counterId++, "Bares emblemáticos de Buenos Aires","Buenos Aires es conocida por su vida nocturna y sus bares emblemáticos. En este tour, los visitantes pueden explorar algunos de los bares más icónicos de la ciudad, aprender sobre su historia y disfrutar de la cultura local a través de la música, la comida y las bebidas tradicionales.", "https://i.postimg.cc/MHSxxvwx/cafe-tortoni.avif", 2, 25.0, 15, "gastronomicos", 0));

    }

    public List<Tour> getAllTours() {
        return tours;
    }

    public Tour getTourById(Integer id) {
        return tours.stream()
                .filter(tour -> tour.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new TourNoEncontradoException("Tour ID " + id + " inválido."));
    }

    public Tour getTourByName(String name) {
        return tours.stream()
                .filter(tour -> tour.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new TourNoEncontradoException("Nombre del tour  " + name + " inválido."));
    }

    public Tour addTour(Tour tour) {
        if (tour.getName() == null || tour.getName().isEmpty()) {
            throw new NombreInvalidoException("Completar el nombre del tour.");
        }
        if (tour.getPrice() < 0) {
            throw new PrecioInvalidoException("El precio del tour debe ser mayor a cero.");
        }
        if (tour.getDuration() <= 0) {
            throw new StockInsuficienteException("La duración del tour debe ser mayor a cero.");
        }
        tour.setId(counterId++);
        tours.add(tour);
        return tour;
                
    }

    

    public void updateTour(Integer id, Tour updatedTour) {
        Tour existingTour = getTourById(id);
        if (existingTour == null) {
            throw new TourNoEncontradoException("Tour ID " + id + " es inválido.");
        }
        if (updatedTour.getName() == null || updatedTour.getName().isEmpty()) {
            throw new NombreInvalidoException("Completar elnombre del tour.");
        }
        if (updatedTour.getPrice() < 0) {
            throw new PrecioInvalidoException("El precio del tour debe ser mayor a cero.");
        }
        if (updatedTour.getDuration() <= 0) {
            throw new StockInsuficienteException("La duración del tour debe ser mayor a cero.");
        }
        existingTour.setName(updatedTour.getName());
        existingTour.setDescription(updatedTour.getDescription());
        existingTour.setImageUrl(updatedTour.getImageUrl());
        existingTour.setDuration(updatedTour.getDuration());
        existingTour.setPrice(updatedTour.getPrice());
        existingTour.setStock(updatedTour.getStock());
        existingTour.setCategory(updatedTour.getCategory());
    }

    public void deleteTour(Integer id) {
        Tour tour = getTourById(id);
        tours.remove(tour);
    }

    public void updateStockAfterPurchase(List<ItemReserva> items) {
        for (ItemReserva item : items) {
            Tour tour = getTourById(item.getTourId());
            if (tour.getStock() < item.getCantidad()) {
                throw new StockInsuficienteException("Stock insuficiente para el tour: " + tour.getName());
            }
            tour.setStock(tour.getStock() - item.getCantidad());
            tour.setSales(tour.getSales() + item.getCantidad());
        }
    }

    public List<Tour> getToursByCategory(String category) {
        List<Tour> filteredTours = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getCategory().equalsIgnoreCase(category)) {
                filteredTours.add(tour);
            }
        }
        return filteredTours;
    }

    public List<Tour> getToursByPriceRange(Double minPrice, Double maxPrice) {
        List<Tour> filteredTours = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getPrice() >= minPrice && tour.getPrice() <= maxPrice) {
                filteredTours.add(tour);
            }
        }
        return filteredTours;
    }
    
    public List<Tour> getToursByDurationRange(Integer minDuration, Integer maxDuration) {
        List<Tour> filteredTours = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getDuration() >= minDuration && tour.getDuration() <= maxDuration) {
                filteredTours.add(tour);
            }
        }
        return filteredTours;
    }

    public List<Tour> getToursByStockAvailability() {
        List<Tour> filteredTours = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getStock() > 0) {
                filteredTours.add(tour);
            }
        }
        return filteredTours;
    }

    public List<Tour> getToursBySales() {
        List<Tour> filteredTours = new ArrayList<>(tours);
        filteredTours.sort((t1, t2) -> t2.getSales().compareTo(t1.getSales()));
        return filteredTours;
    }

    public TourEntity createTour(TourRequest request) {
    TourEntity tour = new TourEntity();
    tour.setName(request.getName());
    return tourRepository.save(tour);
}

}*/
