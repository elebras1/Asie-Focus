package com.elebras.AsieFocus.repository;

import com.elebras.AsieFocus.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}

