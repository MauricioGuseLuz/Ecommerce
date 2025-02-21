package com.ecommerce.api.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "order_items")
public class OrderItem {


    @EmbeddedId
    private OrdemItemPK id;

    private Integer quantity;
    private Double price;

}