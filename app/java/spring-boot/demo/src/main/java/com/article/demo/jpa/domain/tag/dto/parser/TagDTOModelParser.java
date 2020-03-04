package com.article.demo.jpa.domain.tag.dto.parser;

import com.article.demo.jpa.domain.tag.dto.TagDTO;
import com.article.demo.jpa.domain.tag.model.Tag;
import com.article.demo.jpa.dto.parser.DTOModelParser;

import org.springframework.stereotype.Component;

@Component
public class TagDTOModelParser implements DTOModelParser<TagDTO, Tag> {

  @Override
  public TagDTO convertModelToDTO(Tag item) {
    return TagDTO.builder().id(item.getId()).name(item.getName()).build();
  }

  @Override
  public Tag convertDTOToModel(TagDTO item) {
    return Tag.builder().id(item.getId()).name(item.getName()).build();
  }

}