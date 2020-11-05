package org.example.lesson04_lect.repositories;

import org.example.lesson04_lect.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleJpaDAO extends JpaRepository<Article, Long> {
    List<Article> findAllByTitleLike(String title);
    List<Article> findAllByIdBetween(Long startId, Long endId);
}
