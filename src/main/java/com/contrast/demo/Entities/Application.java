package com.contrast.demo.Entities;

import lombok.ToString;
import javax.persistence.*;

@ToString
@Entity
@Table(name = "Apps")
public class Application {

    public Application(String name, Platform platform) {
        this.name = name;
        this.platform = platform;
    }

    public Application() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "app_fk")
    private Platform platform;


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

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }


}
