package com.article.demo.jpa.domain.article.repository;

import com.article.demo.jpa.domain.article.model.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}