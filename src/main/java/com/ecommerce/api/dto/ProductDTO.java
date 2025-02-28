package com.ecommerce.api.dto;

import com.ecommerce.api.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class ProductDTO {

    private Long id;

    @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres")
    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Size(min = 10,  message = "Descrição deve ter minimo 10 caracteres")
    private String description;

    @Positive(message = "Preço deve ser positivo")
    @NotNull(message = "Preço é obrigatório")
    private Double price;

    @NotNull(message = "Imagem é obrigatório")
    private String image;

    @NotNull(message = "Categoria é obrigatório")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Long id, String name, String description, Double price, String image, Set<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.categories = categories.stream().map(CategoryDTO::new).toList();
    }

    public ProductDTO() {

    }
}
