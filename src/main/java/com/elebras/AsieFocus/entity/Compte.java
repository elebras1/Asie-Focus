package com.elebras.AsieFocus.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "T_COMPTE_cpt")
public class Compte {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cpt_id", nullable = false)
    private Integer id;
    @Column(name = "cpt_pseudo", length = 40, nullable = false)
    private String pseudo;
    @Column(name = "cpt_mot_de_passe", length = 100, nullable = false)
    private String motDePasse;

    @Column(name = "cpt_nom", length = 120, nullable = true)
    private String nom;
    @Column(name = "cpt_prenom", length = 120, nullable = true)
    private String prenom;
    @Column(name = "cpt_email", length = 120, nullable = false)
    private String email;
    @Column(name = "cpt_date_creation", nullable = false)
    private LocalDateTime dateCreation;
    @Column(name = "cpt_photo", length = 120, nullable = true)
    private String photo;
    @Column(name = "cpt_is_super_user", nullable = false)
    private boolean isSuperUser;
    @Column(name = "cpt_is_admin", nullable = false)
    private boolean isAdmin;
    @Column(name = "cpt_statut", nullable = false)
    private boolean statut;
    @OneToMany(mappedBy = "compte")
    private List<Article> articles;
    @OneToMany(mappedBy = "compte")
    private List<Commentaire> commentaires;
    @OneToMany(mappedBy = "compte")
    private List<Annonce> annonces;

    @OneToMany(mappedBy = "id.compte", cascade = CascadeType.ALL)
    private List<Favori> favoris;

    protected Compte() {}

    public Compte(String pseudo, String motDePasse, String nom, String prenom, String email, String photo) {
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.photo = photo;
        this.isSuperUser = false;
        this.isAdmin = false;
        this.dateCreation = LocalDateTime.now();
    }

    public Integer getId() {
        return this.id;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public String getMotDePasse() {
        return this.motDePasse;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoto() {
        return this.photo;
    }

    public LocalDateTime getDateCreation() {
        return this.dateCreation;
    }

    public boolean getIsSuperUser() {
        return this.isSuperUser;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    public boolean getStatut() {
        return this.statut;
    }

    public List<Commentaire> getCommentaires() {
        return this.commentaires;
    }

    public List<Article> getArticles() {
        return this.articles;
    }

    public List<Annonce> getAnnonces() {
        return this.annonces;
    }

    public List<Favori> getFavoris() { return this.favoris;}

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setIsSuperUser() {
        this.isSuperUser = !this.isSuperUser;
    }

    public void setIsAdmin() {
        this.isAdmin = !this.isAdmin;
    }

    public void setStatut() {
        this.statut = !this.statut;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }

    public void setFavoris(List<Favori> favoris){ this.favoris = favoris;}
}
