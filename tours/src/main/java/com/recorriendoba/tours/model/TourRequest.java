package com.recorriendoba.tours.model;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class TourRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    private String description;
    private String imageUrl;

    @Positive(message = "El precio debe ser mayor a 0")
    private Double price;
    private Integer stock;
    private Integer duration;

    @NotNull(message = "La categoría es obligatoria")
    private Integer categoryId; 
    private String tags;
    private boolean featured;
}
