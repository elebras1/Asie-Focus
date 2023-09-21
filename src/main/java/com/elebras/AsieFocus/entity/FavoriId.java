package com.elebras.AsieFocus.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavoriId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "cpt_id", nullable = false)
    private Compte compte;
    @ManyToOne
    @JoinColumn(name = "art_id", nullable = false)
    private Article article;

    protected FavoriId() {}
    public FavoriId(Compte compte, Article article) {
        this.compte = compte;
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriId favoriId = (FavoriId) o;
        return Objects.equals(compte, favoriId.compte) &&
                Objects.equals(article, favoriId.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compte, article);
    }
}
