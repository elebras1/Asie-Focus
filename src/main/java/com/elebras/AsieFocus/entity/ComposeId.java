package com.elebras.AsieFocus.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ComposeId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "pay_id", nullable = false)
    private Pays pays;
    @ManyToOne
    @JoinColumn(name = "art_id", nullable = false)
    private Article article;

    private ComposeId() {}

    public ComposeId(Pays pays, Article article) {
        this.pays = pays;
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComposeId composeId = (ComposeId) o;
        return Objects.equals(pays, composeId.pays) &&
                Objects.equals(article, composeId.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pays, article);
    }

}
