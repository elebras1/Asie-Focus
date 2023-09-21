package com.elebras.AsieFocus.entity;
import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "T_PAYS_pay")
public class Pays {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "pay_id", nullable = false)
    private Integer id;
    @Column(name = "pay_nom", nullable = false, length = 80)
    private String nom;
    @Column(name = "pay_description", nullable = false, length = 280)
    private String description;

    @OneToMany(mappedBy = "id.pays", cascade = CascadeType.ALL)
    private List<Compose> composes;

    protected Pays() {}

    public Pays(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getDescription() {
        return this.description;
    }
    public List<Compose> getComposes() {
        return this.composes;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompose(List<Compose> composes) {
        this.composes = composes;
    }
}
