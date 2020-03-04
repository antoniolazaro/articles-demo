package com.article.demo.jpa.domain.article.dto;

import java.time.LocalDateTime;
import java.util.Objects;

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
public class CommentDTO extends BaseDTO implements DTOInterface {

  private Integer id;
  private UserDTO user;
  private ArticleDTO article;
  private CommentDTO commentOrigin;
  private String content;
  private LocalDateTime createdAt;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    CommentDTO comment = (CommentDTO) o;
    return Objects.equals(user.getLogin(), comment.getUser().getLogin())
        && Objects.equals(content, comment.getContent());
  }

  @Override
  public int hashCode() {
    return Objects.hash(user.hashCode(), content);
  }
}