package com.ecommerce.api.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @EmbeddedId
    private OrdemItemPK id = new OrdemItemPK();

    private Integer quantity;

    private Double price;


}
