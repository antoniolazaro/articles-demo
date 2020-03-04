package com.article.demo.jpa.domain.article.service;

import java.util.List;

import com.article.demo.jpa.domain.article.model.Article;
import com.article.demo.jpa.domain.article.repository.ArticleRepository;
import com.article.demo.jpa.exception.BusinessException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {

  private final ArticleRepository repository;

  public List<Article> findAll() {
    return repository.findAll();
  }

  public Article findById(Integer id) {
    return repository.findById(id).orElseThrow(() -> new BusinessException(String.format("Article %d not found", id)));
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