package com.article.demo.jpa.domain.article.controller;

import java.util.List;

import javax.validation.Valid;

import com.article.demo.jpa.domain.article.model.Article;
import com.article.demo.jpa.domain.article.service.ArticleService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/jpa/article")
@RequiredArgsConstructor
public class ArticleController {

  private final ArticleService service;

  @GetMapping("/")
  public @ResponseBody ResponseEntity<List<Article>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public @ResponseBody ResponseEntity<Article> getById(@PathVariable(required = true) Integer id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PostMapping("/")
  public @ResponseBody ResponseEntity<Article> save(@Valid @RequestBody Article article) {
    return ResponseEntity.ok(service.save(article));
  }

  @PutMapping("/{id}")
  public @ResponseBody ResponseEntity<Article> update(@RequestBody Article article,
      @PathVariable(required = true) Integer id) {
    return ResponseEntity.ok(service.update(article, id));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable(required = true) Integer id) {
    service.deleteById(id);
  }

}