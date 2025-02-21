package com.ecommerce.api.dto;

import com.ecommerce.api.entities.Category;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO(String name) {
        this.name = name;

    }

    public CategoryDTO(Category category) {
    }
}
