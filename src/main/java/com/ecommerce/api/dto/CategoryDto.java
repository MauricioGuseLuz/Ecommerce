package com.ecommerce.api.dto;

import com.ecommerce.api.entities.Category;
import lombok.Data;

@Data
public class CategoryDto {

    private Long id;
    private String name;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();

    }
}

