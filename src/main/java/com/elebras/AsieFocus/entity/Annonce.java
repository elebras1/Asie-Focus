package com.elebras.AsieFocus.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "T_ANNONCE_anc")
public class Annonce {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "anc_id", nullable = false)
    private int id;
    @Column(name = "anc_titre", length = 160, nullable = false)
    private String titre;
    @Column(name = "anc_description", length = 280, nullable = false)
    private String description;
    @Column(name = "anc_date_publication", nullable = false)
    private LocalDateTime datePublication;
    @Column(name = "anc_date_modification", nullable = true)
    private LocalDateTime dateModification;
    @Column(name = "anc_statut", nullable = false)
    private boolean statut;
    @ManyToOne
    @JoinColumn(name = "cpt_id", nullable = false)
    private Compte compte;

    protected Annonce() {}

    public Annonce(String titre, String description, Compte compte) {
        this.titre = titre;
        this.description = description;
        this.datePublication = LocalDateTime.now();
        this.statut = true;
        this.compte = compte;
    }

    public int getId() {
        return this.id;
    }

    public String getTitre() {
        return this.titre;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDateTime getDatePublication() {
        return this.datePublication;
    }

    public LocalDateTime getDateModification() {
        return this.dateModification;
    }

    public boolean getStatut() {
        return this.statut;
    }

    public Compte getCompte() {
        return this.compte;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateModified() {
        this.dateModification = LocalDateTime.now();;
    }

    public void setStatut() {
        this.statut = !this.statut;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}

