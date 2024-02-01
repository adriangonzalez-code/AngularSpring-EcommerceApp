package com.driagon.ecommerce.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    // TODO: Set up on-to-many with states
    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<State> states;
}