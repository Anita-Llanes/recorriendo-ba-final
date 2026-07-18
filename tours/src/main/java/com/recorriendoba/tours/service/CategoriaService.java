package com.recorriendoba.tours.service;

import org.springframework.stereotype.Service;
import com.recorriendoba.tours.model.Categoria;
import com.recorriendoba.tours.model.CategoriaEntity;
import com.recorriendoba.tours.exception.CategoriaNoEncontradaException;
import com.recorriendoba.tours.exception.NombreInvalidoException;
import com.recorriendoba.tours.exception.DescripcionInvalidaException;
import com.recorriendoba.tours.exception.ImagenInvalidaException;
import com.recorriendoba.tours.exception.CategoriaInvalidaException;


import java.util.List;
import java.util.ArrayList;

@Service
public class CategoriaService {
    private final List<Categoria> categorias = new ArrayList<>();
    private int counterId = 1;

    public CategoriaService() {
        categorias.add(new Categoria(counterId++, "Artístico", "Explora la riqueza cultural y artística de Buenos Aires a través de sus teatros, galerías y espacios culturales.", "https://i.postimg.cc/cCBWJ01K/cupula-Interior-Colon.jpg"));
        categorias.add(new Categoria(counterId++, "Misterios y Leyendas", "Sumérgete en el lado misterioso de la ciudad con recorridos que revelan historias ocultas y leyendas fascinantes.", "https://i.postimg.cc/VvWwNmst/cementerio-Recoleta.jpg"));
        categorias.add(new Categoria(counterId++, "Íconicos", "Descubre los lugares más emblemáticos de Buenos Aires, desde monumentos históricos hasta barrios con encanto.", "https://i.postimg.cc/d3jF0wQZ/comercio-caminito.jpg"));
        categorias.add(new Categoria(counterId++, "Nocturnos", "Vive la vibrante vida nocturna de Buenos Aires con tours que te llevan a bares, teatros y eventos culturales.", "https://i.postimg.cc/ZnSZZCmC/noche-costanera-sur.jpg"));
        categorias.add(new Categoria(counterId++, "Gastronómicos", "Disfruta de la gastronomía local con tours que te llevan a los mejores restaurantes, bares y mercados de la ciudad.", "https://i.postimg.cc/qMjbh9Md/palermo-gastro.jpg"));
    }

    public List<Categoria> getAllCategorias() {
        return categorias;
    }

    public Categoria getCategoryById(Integer id) {
        return categorias.stream()
                .filter(categoria -> categoria.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CategoriaNoEncontradaException("Categoría con ID " + id + " no encontrada."));
    }

    public void addCategoria(Categoria categoria) {
        if (categoria.getName() == null || categoria.getName().isEmpty()) {
            throw new NombreInvalidoException("El nombre de la categoría no puede estar vacío.");
        }
        if (categoria.getDescription() == null || categoria.getDescription().isEmpty()) {
            throw new DescripcionInvalidaException("La descripción de la categoría no puede estar vacía.");
        }
        if (categoria.getImageUrl() == null || categoria.getImageUrl().isEmpty()) {
            throw new ImagenInvalidaException("La URL de la imagen de la categoría no puede estar vacía.");
        }
        categorias.add(categoria);
    }

    public Categoria getCategoryByName(String name) {
        return categorias.stream()
                .filter(categoria -> categoria.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new CategoriaNoEncontradaException("Categoría con nombre " + name + " no encontrada."));
    }

    public void updateCategoria(Integer id, Categoria updatedCategoria) {
        Categoria existingCategoria = getCategoryById(id);
        if (updatedCategoria.getName() == null || updatedCategoria.getName().isEmpty()) {
            throw new NombreInvalidoException("El nombre de la categoría no puede estar vacío.");
        }
        if (updatedCategoria.getDescription() == null || updatedCategoria.getDescription().isEmpty()) {
            throw new DescripcionInvalidaException("La descripción de la categoría no puede estar vacía.");
        }
        if (updatedCategoria.getImageUrl() == null || updatedCategoria.getImageUrl().isEmpty()) {
            throw new ImagenInvalidaException("La URL de la imagen de la categoría no puede estar vacía.");
        }
        existingCategoria.setName(updatedCategoria.getName());
        existingCategoria.setDescription(updatedCategoria.getDescription());
        existingCategoria.setImageUrl(updatedCategoria.getImageUrl());
    }

    public void deleteCategoria(Integer id) {
        Categoria categoria = getCategoryById(id);
        categorias.remove(categoria);
    }

    public List<Categoria> searchCategoriasByName(String name) {
        List<Categoria> result = new ArrayList<>();
        for (Categoria categoria : categorias) {
            if (categoria.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(categoria);
            }
        }
        return result;
    }

    public List<Categoria> searchCategoriasByDescription(String description) {
        List<Categoria> result = new ArrayList<>();
        for (Categoria categoria : categorias) {
            if (categoria.getDescription().toLowerCase().contains(description.toLowerCase())) {
                result.add(categoria);
            }
        }
        return result;
    }

    public CategoriaEntity findById(Object categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    
    
}
