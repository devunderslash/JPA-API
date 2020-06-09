package com.contrast.demo.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Orgs")
public class Organisation {

    public Organisation(String name, List<Application> applications) {
        this.name = name;
        this.applications = applications;
    }

    public Organisation() {
        super();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = Application.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "org_fk", referencedColumnName = "id")
    private List<Application> applications;



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

    public List<Application> getApplications() { return applications; }

    public void setApplications(List<Application> applications) { this.applications = applications; }


}
