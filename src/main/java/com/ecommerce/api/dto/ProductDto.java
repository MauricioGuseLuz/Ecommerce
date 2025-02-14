package com.ecommerce.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.OptimisticLock;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDto {

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
    private List<CategoryDto> categories = new ArrayList<>();

}
