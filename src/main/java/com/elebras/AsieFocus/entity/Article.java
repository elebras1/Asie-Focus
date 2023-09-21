package com.elebras.AsieFocus.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "T_ARTICLE_art")
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "art_id", nullable = false)
    private Integer id;
    @Column(name = "art_titre", length = 160, nullable = false)
    private String titre;
    @Column(name = "art_description", length = 280, nullable = false)
    private String description;
    @Column(name = "art_contenu", length = 12000, nullable = false)
    private String contenu;
    @Column(name = "art_temps_lecture", length = 60, nullable = false)
    private Integer tempsLecture;
    @Column(name = "art_nombres_vus", nullable = false)
    private Integer nombresVus;
    @Column(name = "art_statut", nullable = false)
    private boolean statut;
    @Column(name = "art_date_publication", nullable = false)
    private LocalDateTime datePublication;
    @Column(name = "art_date_modification", nullable = true)
    private LocalDateTime dateModification;
    @ManyToOne
    @JoinColumn(name = "rbq_id", nullable = false)
    private Rubrique rubrique;
    @ManyToOne
    @JoinColumn(name = "cpt_id", nullable = false)
    private Compte compte;
    @ManyToOne
    @JoinColumn(name = "rsc_id", nullable = false)
    private Ressource ressource;
    @OneToMany(mappedBy = "id.article", cascade = CascadeType.ALL)
    private List<Compose> composes;
    @OneToMany(mappedBy = "id.article", cascade = CascadeType.ALL)
    private List<Favori> favoris;
    @OneToMany(mappedBy = "article")
    private List<Commentaire> commentaires;

    protected Article() {
    }

    public Article(String titre, String description, String contenu, int tempsLecture, Rubrique rubrique, Compte compte, Ressource ressource) {
        this.titre = titre;
        this.description = description;
        this.contenu = contenu;
        this.tempsLecture = tempsLecture;
        this.nombresVus = 0;
        this.datePublication = LocalDateTime.now();
        this.dateModification = null;
        this.statut = true;
        this.rubrique = rubrique;
        this.compte = compte;
        this.ressource = ressource;
    }

    public Integer getId() {
        return this.id;
    }

    public String getTitre() {
        return this.titre;
    }

    public String getDescription() {
        return this.description;
    }

    public String getContenu() {
        return this.contenu;
    }

    public Integer getTempsLecture() {
        return this.tempsLecture;
    }

    public Integer getNombresVus() {
        return this.nombresVus;
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

    public Ressource getRessource() {
        return this.ressource;
    }

    public Rubrique getRubrique() {
        return this.rubrique;
    }

    public Compte getCompte() { return this.compte; }

    public List<Compose> getComposes() {
        return this.composes;
    }

    public List<Commentaire> getCommentaires() {
        return this.commentaires;
    }

    public List<Favori> getFavoris() { return this.favoris;}

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setNombresVus(Integer nombresVus) {
        this.nombresVus = nombresVus;
    }

    public void setStatut() {
        this.statut = !this.statut;
    }

    public void setDateModification() {
        this.dateModification = LocalDateTime.now();
    }

    public void setRubrique(Rubrique rubrique) {
        this.rubrique = rubrique;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    public void setComposes(List<Compose> composes) {
        this.composes = composes;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public void setFavoris(List<Favori> favoris){ this.favoris = favoris;}
}
