package com.elebras.AsieFocus.entity;

import jakarta.persistence.*;

    @Entity
    @Table(name = "T_FAVORI_fav")
    public class Favori {
        @EmbeddedId
        private FavoriId id;
        protected Favori() {}
        public Favori(FavoriId favoriId) {
            this.id = favoriId;
        }

        public FavoriId getId() {
            return id;
        }
    }
