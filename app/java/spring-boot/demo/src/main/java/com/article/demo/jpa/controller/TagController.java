package com.article.demo.jpa.controller;

import java.util.List;

import com.article.demo.jpa.model.Tag;
import com.article.demo.jpa.repository.TagRepository;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/jpa/tag")
public class TagController {

  @Autowired
  private TagRepository repository;

  @GetMapping("/")
  public @ResponseBody ResponseEntity<List<Tag>> findAll() {
    return ResponseEntity.ok(repository.findAll());
  }

  @GetMapping("/{id}")
  public @ResponseBody ResponseEntity<Tag> getById(@PathVariable(required = true) Integer id) {
    return ResponseEntity
        .ok(repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Tag %d not found", id))));
  }

  @PostMapping("/")
  public @ResponseBody ResponseEntity<Tag> save(@RequestBody Tag tag) {
    return ResponseEntity.ok(repository.save(tag));
  }

  @PutMapping("/{id}")
  public @ResponseBody ResponseEntity<Tag> update(@RequestBody Tag tag, @PathVariable Integer id) {
    return repository.findById(id).map(tagDB -> {
      tagDB.setName(tag.getName());
      tagDB.setDescription(tag.getDescription());
      return ResponseEntity.ok(repository.save(tagDB));
    }).orElseGet(() -> {
      return ResponseEntity.ok(repository.save(tag));
    });
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    repository.deleteById(id);
  }

}