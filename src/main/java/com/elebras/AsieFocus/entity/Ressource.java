package com.elebras.AsieFocus.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "T_RESSOURCE_rsc")
public class Ressource {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "rsc_id", nullable = false)
    private Integer id;
    @Column(name = "rsc_image", length = 120, nullable = false)
    private String image;
    @Column(name = "rsc_description", length = 280, nullable = false)
    private String description;

    @OneToMany(mappedBy = "ressource")
    private List<Article> articles;

    protected Ressource() {}

    public Ressource(String image, String description) {
        this.image = image;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    public String getDescription() {
        return this.description;
    }

    public List<Article> getArticles() {
        return this.articles;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
