package com.driagon.ecommerce.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "state")
@Getter
@Setter
public class State implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;
}