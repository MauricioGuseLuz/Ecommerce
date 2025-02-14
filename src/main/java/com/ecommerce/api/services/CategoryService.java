package com.ecommerce.api.services;


import com.ecommerce.api.dto.CategoryDto;
import com.ecommerce.api.entities.Category;
import com.ecommerce.api.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryDto> getAllCategories() {
        List<Category> result = categoryRepository.findAll();
        List<CategoryDto> list = result.stream().map(x -> new CategoryDto(x)).toList();
        return list;

    }

}
