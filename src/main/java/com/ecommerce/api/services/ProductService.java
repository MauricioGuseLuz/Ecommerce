package com.ecommerce.api.services;


import com.ecommerce.api.dto.CategoryDTO;
import com.ecommerce.api.dto.ProductDTO;
import com.ecommerce.api.entities.Product;
import com.ecommerce.api.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> productToProductDTO(product)).toList();
    }
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        ProductDTO productDTO = productToProductDTO(product);
        return productDTO;
    }
    @Transactional
    public ProductDTO create(ProductDTO productDTO) {
        Product product = productDTOToProduct(productDTO);
        Product savedProduct = productRepository.save(product);
        return productToProductDTO(savedProduct);
    }
    @Transactional
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productDTOToProduct(productDTO);
        product.setId(id);
        //o repository não salva um DTO, ele salva entity
        product = productRepository.save(product);
        return productToProductDTO(product);
    }
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    public ProductDTO productToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setImage(product.getImage());
        productDTO.setCategories(product.getCategories().stream().map(category -> new CategoryDTO(category.getId(), category.getName())).toList());
        return productDTO;
    }
    public Product productDTOToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImage(productDTO.getImage());
        product.setCategories(productDTO.getCategories());
        return product;
    }
}
