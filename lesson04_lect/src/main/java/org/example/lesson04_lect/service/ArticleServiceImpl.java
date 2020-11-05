package org.example.lesson04_lect.service;

import org.example.lesson04_lect.domain.Article;
import org.example.lesson04_lect.domain.Author;
import org.example.lesson04_lect.domain.Category;
import org.example.lesson04_lect.repositories.ArticleJpaDAO;
import org.example.lesson04_lect.repositories.AuthorJpaDAO;
import org.example.lesson04_lect.repositories.CategoryJpaDAO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ArticleServiceImpl {

    private final ArticleJpaDAO articleJpaDAO;
    private final AuthorJpaDAO authorJpaDAO;
    private final CategoryJpaDAO categoryJpaDAO;


    public ArticleServiceImpl(ArticleJpaDAO articleJpaDAO, AuthorJpaDAO authorJpaDAO, CategoryJpaDAO categoryJpaDAO) {
        this.articleJpaDAO = articleJpaDAO;
        this.authorJpaDAO = authorJpaDAO;
        this.categoryJpaDAO = categoryJpaDAO;
    }

    @Transactional
    public void saveAndSet(Article article, Author author, Category category) {
        Author savedAuthor = authorJpaDAO.save(author);
        Category savedCategory = categoryJpaDAO.save(category);
        article.setAuthor(author);
        article.setCategory(category);
        articleJpaDAO.save(article);
    }

    @Transactional
    public Article findById(Long id) {
        return articleJpaDAO.findById(id).orElse(null);
    }
}
