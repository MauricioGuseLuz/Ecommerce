package com.ecommerce.api.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
@Table(name = "tb_payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(columnDefinition = "Timestamp without time zone")
    private Instant moment;

    @OneToOne
    @MapsId
    private Order order;
}
