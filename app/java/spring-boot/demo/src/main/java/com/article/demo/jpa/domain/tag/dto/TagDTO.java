package com.article.demo.jpa.domain.tag.dto;

import java.util.Objects;

import com.article.demo.jpa.dto.BaseDTO;
import com.article.demo.jpa.dto.parser.DTOInterface;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagDTO extends BaseDTO implements DTOInterface {

  private Integer id;
  private String name;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    TagDTO tag = (TagDTO) o;
    return Objects.equals(name, tag.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}