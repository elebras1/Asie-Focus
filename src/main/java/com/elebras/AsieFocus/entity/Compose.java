package com.elebras.AsieFocus.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "T_COMPOSE_cps")
public class Compose {
    @EmbeddedId
    private ComposeId id;
    protected Compose() {}
    public Compose(ComposeId composeId) {
        this.id = composeId;
    }

    public ComposeId getId() {
        return id;
    }
}
