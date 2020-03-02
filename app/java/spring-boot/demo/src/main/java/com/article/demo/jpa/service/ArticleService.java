package com.article.demo.jpa.service;

import java.util.List;

import com.article.demo.jpa.model.Article;
import com.article.demo.jpa.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

  @Autowired
  ArticleRepository repository;

  public List<Article> findAll() {
    return repository.findAll();
  }

  public Article findById(Integer id) {
    return repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Article %d not found", id)));
  }

  public Article save(Article article) {
    return repository.save(article);
  }

  public Article update(Article article, Integer id) {
    return repository.findById(id).map(articleDB -> {
      articleDB.setTitle(article.getTitle());
      articleDB.setShortDescription(article.getShortDescription());
      articleDB.setContent(article.getContent());
      articleDB.setUser(article.getUser());
      return repository.save(articleDB);
    }).orElseGet(() -> {
      return repository.save(article);
    });
  }

  public void deleteById(Integer id) {
    repository.deleteById(id);
  }
}