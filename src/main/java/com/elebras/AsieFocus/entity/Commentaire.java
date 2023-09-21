package com.elebras.AsieFocus.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "T_COMMENTAIRE_com")
public class Commentaire {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "com_id", nullable = false)
    private Integer id;
    @Column(name = "com_commentaire", length = 280, nullable = false)
    private String commentaire;
    @Column(name = "com_statut", nullable = false)
    private boolean statut;
    @Column(name = "com_date_publication", nullable = false)
    private LocalDateTime datePublication;
    @ManyToOne
    @JoinColumn(name="art_id", nullable = false)
    private Article article;
    @ManyToOne
    @JoinColumn(name="cpt_id", nullable = false)
    private Compte compte;

    protected Commentaire() {}

    public Commentaire(String commentaire, Article article, Compte compte) {
        this.commentaire = commentaire;
        this.statut = true;
        this.article = article;
        this.compte = compte;
        this.datePublication = LocalDateTime.now();
    }

    public Integer getId() {
        return this.id;
    }

    public String getCommentaire() {
        return this.commentaire;
    }

    public boolean getStatut() {
        return this.statut;
    }

    public Article getArticle() {
        return this.article;
    }

    public Compte getCompte() {
        return this.compte;
    }

    public LocalDateTime getDatePublication() {
        return this.datePublication;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setStatut() {
        this.statut = !this.statut;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}

