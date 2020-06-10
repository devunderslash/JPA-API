package com.contrast.demo.Entities;

import lombok.ToString;
import javax.persistence.*;

@ToString
@Entity
@Table(name = "Plats")
public class Platform {

    public Platform(String name) {
        this.name = name;
    }

    public Platform() {
        super();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
