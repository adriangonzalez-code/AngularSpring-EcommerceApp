package com.driagon.ecommerce.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "UNIT_PRICE")
    private BigDecimal unitPrice;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "UNITS_IN_STOCK")
    private int unitsInStock;

    @Column(name = "DATE_CREATED")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "LAST_UPDATED")
    @UpdateTimestamp
    private Date lastUpdated;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;
}