package com.elebras.AsieFocus.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "T_RUBRIQUE_rbq")
public class Rubrique {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "rbq_id", nullable = false)
    private Integer id;
    @Column(name = "rsc_titre", length = 160, nullable = false)
    private String titre;
    @Column(name = "rsc_description", length = 280, nullable = false)
    private String description;
    @OneToMany(mappedBy = "rubrique")
    private List<Article> articles;

    protected Rubrique() {
    }

    public Rubrique(String titre, String description) {
        this.titre = titre;
        this.description = description;
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

    public List<Article> getArticles() {
        return this.articles;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}