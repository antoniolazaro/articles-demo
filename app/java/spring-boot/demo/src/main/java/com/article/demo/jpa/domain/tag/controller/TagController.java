package com.article.demo.jpa.domain.tag.controller;

import java.util.List;

import com.article.demo.jpa.domain.tag.dto.TagDTO;
import com.article.demo.jpa.domain.tag.dto.parser.TagDTOModelParser;
import com.article.demo.jpa.domain.tag.service.TagService;

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
@RequestMapping("/api/jpa/tag")
@RequiredArgsConstructor
public class TagController {

  private final TagService service;
  private final TagDTOModelParser DTOModelParser;

  @GetMapping("/")
  public ResponseEntity<List<TagDTO>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<TagDTO> getById(@PathVariable(required = true) Integer id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PostMapping("/")
  public ResponseEntity<TagDTO> save(TagDTO item) {
    return ResponseEntity.ok(service.save(DTOModelParser.convertDTOToModel(item)));
  }

  @PutMapping("/{id}")
  public ResponseEntity<TagDTO> update(TagDTO item, @PathVariable Integer id) {
    return ResponseEntity.ok(service.update(DTOModelParser.convertDTOToModel(item), id));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    service.deleteById(id);
  }

}