package com.recorriendoba.tours.model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Categoria {
    private Integer id;
    private String name;
    private String description;
    private String imageUrl;
}
