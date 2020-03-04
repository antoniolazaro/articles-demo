package com.article.demo.jpa.domain.article.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.article.demo.jpa.domain.tag.dto.TagDTO;
import com.article.demo.jpa.domain.user.dto.UserDTO;
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
public class ArticleDTO extends BaseDTO implements DTOInterface {

  private Integer id;
  private String title;
  private String shortDescription;
  private String content;
  private UserDTO user;
  private LocalDateTime createdAt;
  private LocalDateTime lastUpdateAt;
  private LocalDateTime lastViewAt;
  private BigDecimal timeReadingAverage;
  private List<TagDTO> tags;
  private List<CommentDTO> comments;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    ArticleDTO comment = (ArticleDTO) o;
    return Objects.equals(user.getLogin(), comment.getUser().getLogin()) && Objects.equals(title, comment.getTitle());
  }

  @Override
  public int hashCode() {
    return Objects.hash(user.hashCode(), title);
  }
}