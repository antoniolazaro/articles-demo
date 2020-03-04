package com.article.demo.jpa.domain.tag.service;

import java.time.LocalDateTime;
import java.util.List;

import com.article.demo.jpa.domain.tag.dto.TagDTO;
import com.article.demo.jpa.domain.tag.dto.parser.TagDTOModelParser;
import com.article.demo.jpa.domain.tag.model.Tag;
import com.article.demo.jpa.domain.tag.repository.TagRepository;
import com.article.demo.jpa.exception.BusinessException;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagService {

  private final TagRepository repository;
  private final TagDTOModelParser DTOModelParser;

  public List<TagDTO> findAll() {
    return DTOModelParser.convertListModelToListDTO(repository.findAll());
  }

  public TagDTO findById(Integer id) {
    Tag item = repository.findById(id)
        .orElseThrow(() -> new BusinessException(String.format("Tag with id %d not found", id)));
    return DTOModelParser.convertModelToDTO(item);
  }

  public TagDTO save(Tag item) {
    return DTOModelParser.convertModelToDTO(repository.save(item));
  }

  public TagDTO update(Tag item, Integer id) {
    return repository.findById(id).map(itemDB -> {
      Tag newTag = Tag.builder().id(id).name(item.getName()).description(item.getDescription()).build();
      return this.save(newTag);
    }).orElseGet(() -> {
      return this.save(item);
    });
  }

  public void deleteById(Integer id) {
    repository.deleteById(id);
  }

  public List<TagDTO> findByName(String name) {
    return DTOModelParser.convertListModelToListDTO(repository.findByName(name));
  }

  public List<TagDTO> findByNamePaged(String name, Integer currentPage, Integer pageSize) {
    return DTOModelParser
        .convertListModelToListDTO(repository.findByNamePaged(name, PageRequest.of(currentPage, pageSize)).toList());
  }

  public List<TagDTO> findByNamePaged(String name, Integer currentPage, Integer pageSize, String sortBy) {
    return DTOModelParser.convertListModelToListDTO(
        repository.findByNamePaged(name, PageRequest.of(currentPage, pageSize, Sort.by(sortBy).ascending())).toList());
  }

  public List<TagDTO> findByPartOfDescription(String parteOfDescription) {
    return DTOModelParser.convertListModelToListDTO(repository.findByPartOfDescription(parteOfDescription));
  }

  public List<TagDTO> findByCreationPeriod(LocalDateTime startPeriod, LocalDateTime endPeriod) {
    return DTOModelParser.convertListModelToListDTO(repository.findByCreationPeriod(startPeriod, endPeriod));
  }

  public void deleteByName(String name) {
    repository.deleteByName(name);
  }
}